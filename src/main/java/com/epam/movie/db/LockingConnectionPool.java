package com.epam.movie.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public enum LockingConnectionPool implements ConnectionPool {
    INSTANCE;

    private static final Logger LOG = LoggerFactory.getLogger(LockingConnectionPool.class);

    private static final int INITIAL_CONNECTIONS_AMOUNT = 8;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/movie_rating_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private final AtomicBoolean initialized = new AtomicBoolean(false);

    private final Queue<ProxyConnection> availableConnections = new LinkedBlockingDeque<>();
    private final List<ProxyConnection> givenAwayConnections = new CopyOnWriteArrayList<>();

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    @Override
    public boolean init() {
        if (initialized.compareAndSet(false, true)) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            } catch (SQLException e) {
                LOG.error("Couldn't register driver", e);
            }
            try {
                for (int i = 0; i < INITIAL_CONNECTIONS_AMOUNT; i++) {
                    final Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                    final ProxyConnection proxyConnection = new ProxyConnection(connection, this);
                    availableConnections.add(proxyConnection);
                }
            } catch (SQLException e) {
                LOG.error("Couldn't create a connection", e);
//                todo:
//                if (failOnConnectionException) {
//                    throw new CouldNotInitializeConnectionPoolError("Failed to create Connection", e);
//                }
            }
        }
        return isInitialized();
    }

    @Override
    public boolean isInitialized() {
        return initialized.get();
    }

    @Override
    public ProxyConnection takeConnection() {
        ProxyConnection proxyConnection = null;
        lock.lock();
        try {
            while (availableConnections.isEmpty()) {
                condition.await();
            }
            proxyConnection = availableConnections.poll();
            givenAwayConnections.add(proxyConnection);
        } catch (InterruptedException e) {
            LOG.error("error", e);
        } finally {
            lock.unlock();
        }
        return proxyConnection;
    }

    @Override
    public void returnConnection(Connection connection) {
        lock.lock();
        try {
            if (givenAwayConnections.remove(connection)) {
                availableConnections.add((ProxyConnection) connection);
                condition.signalAll();
            } else {
                LOG.warn("Attempt to add unknown connection to Connection Pool. Connection: {}", connection);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean shutDown() {
        if (initialized.compareAndSet(true, false)) {
            closeConnections();
            deregisterDrivers();
            return true;
        }
        return false;
    }

    private void closeConnections() {
        lock.lock();
        try {
            closeConnections(this.availableConnections);
            closeConnections(this.givenAwayConnections);
        } finally {
            lock.unlock();
        }

    }

    private void closeConnections(Collection<ProxyConnection> connections) {
        for (ProxyConnection connection : connections) {
            closeConnection(connection);
        }
    }

    private void closeConnection(ProxyConnection conn) {
        try {
            conn.realClose();
            LOG.info("Closed connection {}", conn);
        } catch (SQLException e) {
            LOG.error("Could not close connection", e);
        }
    }

    private static void deregisterDrivers() {
        LOG.trace("unregistering sql drivers");
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(drivers.nextElement());
            } catch (SQLException e) {
                LOG.error("could not deregister driver", e);
            }
        }
    }
}
