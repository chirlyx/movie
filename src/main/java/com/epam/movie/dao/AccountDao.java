package com.epam.movie.dao;

import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;
import com.epam.movie.mapper.AccountMapper;
import com.epam.movie.model.Account;

import java.util.List;
import java.util.Optional;

public class AccountDao extends AbstractDao<Account> implements EntityDao<Account> {
    private static final String READ_ALL = "SELECT * FROM account \n" +
            "LEFT JOIN user_account ON account.id = user_account.user_id \n" +
            "LEFT JOIN role ON account.role_id = role.id \n" +
            "LEFT JOIN status ON user_account.status_id = status.id";
    private static final String CREATE = "INSERT INTO account (login, password, role_id) \n" +
            "VALUES (?, ?, '2');";
    private static final String RETRIEVE_BY_LOGIN = "SELECT * FROM account WHERE login = ?";


    public AccountDao(ProxyConnection proxyConnection) {
        super(proxyConnection);
    }

    @Override
    public Account create(Account entity) throws DaoException {
        final String login = entity.getLogin();
        final String password = entity.getPassword();
        executeUpdate(CREATE, login, password);
        return retrieveByLogin(login);
    }

    @Override
    public List<Account> readAll() {
        return null;
    }

    @Override
    public List<Account> readWithLimit(int offset, int limit) throws DaoException {
        return null;
    }

    @Override
    public Optional<Account> readById(int id) throws DaoException {
        return null;
    }

    public Account retrieveByLogin(String login) throws DaoException {
        return executeForSingleResult(RETRIEVE_BY_LOGIN, new AccountMapper(), login).orElse(new Account());
    }

    @Override
    public Account update(Account entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
