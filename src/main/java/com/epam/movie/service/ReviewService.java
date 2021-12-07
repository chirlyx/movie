package com.epam.movie.service;

import com.epam.movie.dao.DaoHelper;
import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.dao.ReviewDao;
import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Review;

public class ReviewService {
    private final DaoHelperFactory daoHelperFactory;

    public ReviewService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Review submit(Review review) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            return reviewDao.create(review);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Boolean isReview(Integer userId, Integer movieId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            return reviewDao.retrieveByUserAndMovie(userId, movieId).isPresent();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Review retrieveByUserAndMovieId(Integer userId, Integer movieId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            return reviewDao.retrieveByUserAndMovie(userId, movieId).orElse(new Review());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public boolean delete(Integer userId, Integer movieId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            Review review = retrieveByUserAndMovieId(userId, movieId);
            return reviewDao.delete(review.getId());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
