package com.epam.movie.service;

import com.epam.movie.dao.DaoHelper;
import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.dao.MovieDao;
import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Movie;

import java.util.List;

public class MovieService {
    private DaoHelperFactory daoHelperFactory;

    public MovieService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Movie> retrieveFromTo (int offset, int limit) throws ServiceException {
        try(DaoHelper daoHelper = daoHelperFactory.create()){
            MovieDao movieDao = daoHelper.createMovieDao();
            return movieDao.readWithLimit(offset, limit);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
