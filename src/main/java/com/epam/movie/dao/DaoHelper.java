package com.epam.movie.dao;

import com.epam.movie.db.LockingConnectionPool;
import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {
    private final ProxyConnection proxyConnection;

    public DaoHelper(LockingConnectionPool instance) {
        proxyConnection = instance.takeConnection();
    }

    public UserDao createUserDao() {
        return new UserDao(proxyConnection);
    }

    public MovieDao createMovieDao() {
        return new MovieDao(proxyConnection);
    }

    public AccountDao createAccountDao() {
        return new AccountDao(proxyConnection);
    }

    public ActorDao createActorDao() {
        return new ActorDao(proxyConnection);
    }

    public ReviewDao createReviewDao() {
        return new ReviewDao(proxyConnection);
    }

    @Override
    public void close() throws Exception {
        try {
            proxyConnection.setAutoCommit(true);
            proxyConnection.close();
        } catch (SQLException exception) {
            throw new DaoException(exception.getMessage(), exception);
        }
    }
}
