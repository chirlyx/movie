package com.epam.movie.service;

import com.epam.movie.dao.DaoHelper;
import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.dao.UserDao;
import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.User;

import java.util.List;

public class UserService {
    private DaoHelperFactory daoHelperFactory;

    private static final String TABLE_NAME = "user_account";

    public UserService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public User retrieveById(Integer id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            return userDao.readById(id).orElse(new User());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public List<User> retrieveFromTo(int offset, int limit) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            return userDao.readWithLimit(offset, limit);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public User update(User user) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            return userDao.update(user);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public void create(User user) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            userDao.create(user);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Integer numberOfRecords() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            return userDao.retrieveNumberOfRecords(TABLE_NAME);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
