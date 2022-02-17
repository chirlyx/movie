package com.epam.movie.dao;

import com.epam.movie.db.LockingConnectionPool;

public class DaoHelperFactory {

    public DaoHelper create() {
        return new DaoHelper(LockingConnectionPool.INSTANCE);
    }
}
