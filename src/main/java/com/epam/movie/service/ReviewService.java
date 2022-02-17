package com.epam.movie.service;

import com.epam.movie.dao.DaoHelper;
import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.dao.ReviewDao;
import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReviewService {
    private static final Logger LOG = LoggerFactory.getLogger(ReviewService.class);

    private final DaoHelperFactory daoHelperFactory;

    public ReviewService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Review submit(Review review) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            return reviewDao.create(review);
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    public Boolean isReview(Integer userId, Integer movieId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            return reviewDao.retrieveByUserAndMovie(userId, movieId).isPresent();
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    public Review retrieveByUserAndMovieId(Integer userId, Integer movieId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            return reviewDao.retrieveByUserAndMovie(userId, movieId).orElse(new Review());
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    public List<Review> retrieveByUser(Integer userId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            return reviewDao.retrieveByUser(userId);
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    public Integer retrieveCountByUser(Integer userId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            return reviewDao.retrieveCountByUser(userId);
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    public boolean delete(Integer userId, Integer movieId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            Review review = retrieveByUserAndMovieId(userId, movieId);
            return reviewDao.delete(review.getId());
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            throw new ServiceException(e);
        }
    }
}
