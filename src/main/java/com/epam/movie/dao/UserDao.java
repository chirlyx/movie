package com.epam.movie.dao;

import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;
import com.epam.movie.mapper.UserMapper;
import com.epam.movie.model.User;

import java.util.List;
import java.util.Optional;

public class UserDao extends AbstractDao<User> implements EntityDao<User> {
    private static final String READ_BY_ID = "SELECT * FROM user_account WHERE user_id = ?";

    public UserDao(ProxyConnection proxyConnection) {
        super(proxyConnection);
    }

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public List<User> readAll() {
        return null;
    }

    @Override
    public List<User> readWithLimit(int start, int total) {
        return null;
    }

    @Override
    public Optional<User> readById(int id) throws DaoException {
        return executeForSingleResult(READ_BY_ID, new UserMapper(), id);
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    protected List<User> retrieveAll() {
        return null;
    }

    @Override
    protected void create(String query, Object... params) {

    }
}
