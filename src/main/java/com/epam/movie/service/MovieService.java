package com.epam.movie.service;

import com.epam.movie.dao.DaoHelper;
import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.dao.MovieDao;
import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Movie;

import java.util.List;

public class MovieService {
    private DaoHelperFactory daoHelperFactory;

    private static final String TABLE_NAME = "movie";
    private static final String RETRIEVE_ACTIVE_MOVIES_COUNT = "SELECT COUNT(*) FROM movie WHERE (deleted = 0)";
    private static final String RETRIEVE_DELETED_MOVIES_COUNT = "SELECT COUNT(*) FROM movie WHERE (deleted = 1)";

    public MovieService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public int create(Movie movie) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.create(movie).getId();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Movie retrieveById(int id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            Movie movie = movieDao.readById(id).orElse(new Movie());
            return movie;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public List<Movie> retrieveActiveFromTo(int offset, int limit) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.readActiveWithLimit(offset, limit);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public List<Movie> retrieveDeletedFromTo(int offset, int limit) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.readDeletedWithLimit(offset, limit);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Movie update(Movie movie) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.update(movie);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public boolean delete(Integer id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.delete(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public boolean restore(Integer id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.restore(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Integer numberOfActiveMovies() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.retrieveNumberOfRecordsWhere(RETRIEVE_ACTIVE_MOVIES_COUNT);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Integer numberOfDeletedMovies() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.retrieveNumberOfRecordsWhere(RETRIEVE_DELETED_MOVIES_COUNT);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
