package com.epam.movie.dao;

import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;
import com.epam.movie.mapper.MovieMapper;
import com.epam.movie.model.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDao extends AbstractDao<Movie> implements EntityDao<Movie> {
    private static final String READ_WITH_LIMIT = "SELECT * FROM movie LIMIT ?, ?";
    private static final String READ_ALL = "SELECT id, title, year FROM movie";

    protected MovieDao(ProxyConnection proxyConnection) {
        super(proxyConnection);
    }

    @Override
    protected List<Movie> retrieveAll() {
        return null;
    }

    @Override
    public List<Movie> readWithLimit(int offset, int limit) throws DaoException {
        return executeQuery(READ_WITH_LIMIT, new MovieMapper(), (offset - 1), limit);
    }

    @Override
    protected void create(String query, Object... params) {

    }

    @Override
    public Movie create(Movie entity) {
        return null;
    }

    @Override
    public List<Movie> readWithLimit() {
        return null;
    }

    @Override
    public Optional<Movie> readById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
