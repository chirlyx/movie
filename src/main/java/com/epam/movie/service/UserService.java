package com.epam.movie.service;

import com.epam.movie.dao.DaoHelper;
import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.dao.UserDao;
import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.User;

import java.util.Optional;

public class UserService {
    private DaoHelperFactory daoHelperFactory;

    public UserService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<User> retrieveById (Integer id) throws ServiceException {
        try(DaoHelper daoHelper = daoHelperFactory.create()){
            UserDao userDao = daoHelper.createUserDao();
            return userDao.readById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
