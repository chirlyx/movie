package com.epam.movie.mapper;

import com.epam.movie.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {

    @Override
    public Account map(ResultSet resultSet) throws SQLException {
        final Integer id = resultSet.getInt("id");
        final String login = resultSet.getString("login");
        final String password = resultSet.getString("password");
        final Integer roleId = resultSet.getInt("role_id");
        return new Account(id, login, password, roleId);
    }
}
