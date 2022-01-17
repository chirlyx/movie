package com.epam.movie.dao;

import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;
import com.epam.movie.mapper.MovieMapper;
import com.epam.movie.mapper.UserMapper;
import com.epam.movie.model.Movie;
import com.epam.movie.model.User;

import java.util.List;
import java.util.Optional;

public class UserDao extends AbstractDao<User> implements EntityDao<User> {
    private static final String READ_BY_ID = "SELECT * FROM user_account WHERE user_id = ?";
    private static final String READ_WITH_LIMIT = "SELECT * FROM user_account LIMIT ?, ?";
    private static final String CREATE = "INSERT INTO user_account (user_id, first_name, last_name, status_id) \n" +
            "VALUES (?, ?, ?, '1');";
    private static final String UPDATE = "UPDATE user_account SET first_name = ?, last_name = ?, status_id = ? WHERE (user_id = ?)";

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
    public List<User> readWithLimit(int offset, int limit) throws DaoException {
        return executeQuery(READ_WITH_LIMIT, new UserMapper(), (offset - 1), limit);
    }

    @Override
    public Optional<User> readById(int id) throws DaoException {
        return executeForSingleResult(READ_BY_ID, new UserMapper(), id);
    }

    @Override
    public User update(User entity) throws DaoException {
        Integer id = entity.getId();
        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        Integer statusId = entity.getStatus().getStatusId();
        executeUpdate(UPDATE, firstName, lastName, statusId, id);
        return readById(id).orElse(new User());
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
