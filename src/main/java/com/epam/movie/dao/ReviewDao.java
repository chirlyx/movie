package com.epam.movie.dao;

import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;
import com.epam.movie.mapper.ReviewMapper;
import com.epam.movie.model.Review;

import java.util.List;
import java.util.Optional;

public class ReviewDao extends AbstractDao<Review> implements EntityDao<Review> {
    private static final String CREATE = "INSERT INTO review (user_id, movie_id, mark, comment) \n" +
            "VALUES (?, ?, ?, ?)";
    private static final String RETRIEVE_BY_USER_AND_MOVIE = "SELECT * FROM review WHERE user_id = ? AND movie_id = ?";
    private static final String RETRIEVE_BY_USER = "SELECT * FROM review WHERE user_id = ?";
    private static final String RETRIEVE_COUNT_BY_USER = "SELECT COUNT(*) FROM review WHERE user_id = ?";
    private static final String RETRIEVE_BY_ID = "SELECT * FROM review WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM review WHERE id = ?";


    protected ReviewDao(ProxyConnection proxyConnection) {
        super(proxyConnection);
    }

    @Override
    public Review create(Review entity) throws DaoException {
        final Integer userId = entity.getUserId();
        final Integer movieId = entity.getMovieId();
        final Integer mark = entity.getMark();
        final String comment = entity.getComment();
        executeUpdate(CREATE, userId, movieId, mark, comment);
        return retrieveByUserAndMovie(userId, movieId).orElse(new Review());
    }

    public Optional<Review> retrieveByUserAndMovie(Integer userId, Integer movieId) throws DaoException {
        return executeForSingleResult(RETRIEVE_BY_USER_AND_MOVIE, new ReviewMapper(), userId, movieId);
    }

    public List<Review> retrieveByUser(Integer userId) throws DaoException {
        return executeQuery(RETRIEVE_BY_USER, new ReviewMapper(), userId);
    }

    public Integer retrieveCountByUser(Integer userId) throws DaoException {
        return retrieveNumberOfRecordsWhere(RETRIEVE_COUNT_BY_USER, userId);
    }

    @Override
    public List<Review> readAll() {
        return null;
    }

    @Override
    public List<Review> readWithLimit(int offset, int limit) throws DaoException {
        return null;
    }

    @Override
    public Optional<Review> readById(int id) throws DaoException {
        return executeForSingleResult(RETRIEVE_BY_ID, new ReviewMapper(), id);
    }

    @Override
    public Review update(Review entity) {
        return null;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        executeUpdate(DELETE_BY_ID, id);
        return !readById(id).isPresent();
    }
}
