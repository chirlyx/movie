package com.epam.movie.db;

import java.sql.Connection;

public interface ConnectionPool {

    boolean init();

    boolean isInitialized();

    Connection takeConnection() throws InterruptedException;

    void returnConnection(Connection connection);

    boolean shutDown();
}
