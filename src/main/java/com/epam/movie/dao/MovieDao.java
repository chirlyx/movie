package com.epam.movie.dao;

import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;
import com.epam.movie.mapper.ActorMapper;
import com.epam.movie.mapper.MovieMapper;
import com.epam.movie.model.Actor;
import com.epam.movie.model.Movie;

import java.util.List;
import java.util.Optional;

public class MovieDao extends AbstractDao<Movie> implements EntityDao<Movie> {
    private static final String READ_WITH_LIMIT = "SELECT * FROM movie LIMIT ?, ?";
    private static final String READ_ALL = "SELECT id, title, year FROM movie";
    private static final String READ_BY_ID = "SELECT * FROM movie WHERE id = ?";

    protected MovieDao(ProxyConnection proxyConnection) {
        super(proxyConnection);
    }

    @Override
    public List<Movie> readWithLimit(int offset, int limit) throws DaoException {
        return executeQuery(READ_WITH_LIMIT, new MovieMapper(), (offset - 1), limit);
    }

    @Override
    public Movie create(Movie entity) {
        return null;
    }

    @Override
    public List<Movie> readAll() {
        return null;
    }

    @Override
    public Optional<Movie> readById(int id) throws DaoException {
        return executeForSingleResult(READ_BY_ID, new MovieMapper(), id);
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
