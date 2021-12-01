package com.epam.movie.service;

import com.epam.movie.dao.AccountDao;
import com.epam.movie.dao.DaoHelper;
import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Account;
import org.mindrot.jbcrypt.BCrypt;

public class AccountService {
    private DaoHelperFactory daoHelperFactory;

    public AccountService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public int create(Account account) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            AccountDao accountDao = daoHelper.createAccountDao();
            account.setPassword(hashPassword(account.getPassword()));
            return accountDao.create(account).getId();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public boolean checkLoginAndPassword(String login, String password) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            AccountDao accountDao = daoHelper.createAccountDao();
            Account account = accountDao.retrieveByLogin(login.trim());
            return checkPassword(password, account.getPassword());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public Account retrieveByLogin(String login) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            AccountDao accountDao = daoHelper.createAccountDao();
            return accountDao.retrieveByLogin(login.trim());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private boolean checkPassword(String password, String expectedHash) {
        return expectedHash != null && BCrypt.checkpw(password, expectedHash);
    }

}
