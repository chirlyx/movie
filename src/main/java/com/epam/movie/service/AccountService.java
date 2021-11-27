package com.epam.movie.service;

import com.epam.movie.dao.AccountDao;
import com.epam.movie.dao.DaoHelper;
import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Account;

public class AccountService {
    private DaoHelperFactory daoHelperFactory;

    public AccountService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public int create (Account account) throws ServiceException {
        try(DaoHelper daoHelper = daoHelperFactory.create()){
            AccountDao accountDao = daoHelper.createAccountDao();
            return accountDao.create(account).getId();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
