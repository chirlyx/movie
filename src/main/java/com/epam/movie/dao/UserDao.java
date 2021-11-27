package com.epam.movie.dao;

import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;
import com.epam.movie.mapper.UserMapper;
import com.epam.movie.model.User;

import java.util.List;
import java.util.Optional;

public class UserDao extends AbstractDao<User> implements EntityDao<User> {
    private static final String READ_BY_ID = "SELECT * FROM user_account WHERE user_id = ?";
    private static final String CREATE = "INSERT INTO user_account (user_id, first_name, last_name, status_id) \n" +
            "VALUES (?, ?, ?, '1');";

    public UserDao(ProxyConnection proxyConnection) {
        super(proxyConnection);
    }

    @Override
    public User create(User entity) throws DaoException {
        final Integer id = entity.getId();
        final String firstName = entity.getFirstName();
        final String lastName = entity.getLastName();
        executeUpdate(CREATE, id, firstName, lastName);
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
/*
    @Override
    protected List<User> retrieveAll() {
        return null;
    }

    @Override
    protected void create(String query, Object... params) {
    }*/
}
