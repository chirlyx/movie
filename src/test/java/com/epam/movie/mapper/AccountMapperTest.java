package com.epam.movie.mapper;

import com.epam.movie.model.Account;
import com.epam.movie.model.Role;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapperTest {
    private static final String ID = "id";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLE_ID = "role_id";
    private static final Integer EXPECTED_ID = 1;
    private static final String EXPECTED_LOGIN = "login";
    private static final String EXPECTED_PASSWORD = "password";
    private static final Integer EXPECTED_ROLE_ID = 1;
    private static final Role EXPECTED_ROLE = Role.ADMIN;

    private ResultSet mock;

    @BeforeTest
    public void init() {
        mock = Mockito.mock(ResultSet.class);
    }

    @Test
    public void testMovieRowMapper() throws SQLException {
        Mockito.when(mock.getInt(ID)).thenReturn(EXPECTED_ID);
        Mockito.when(mock.getString(LOGIN)).thenReturn(EXPECTED_LOGIN);
        Mockito.when(mock.getString(PASSWORD)).thenReturn(EXPECTED_PASSWORD);
        Mockito.when(mock.getInt(ROLE_ID)).thenReturn(EXPECTED_ROLE_ID);

        AccountMapper accountMapper = new AccountMapper();
        Account account = accountMapper.map(mock);

        Assert.assertEquals(account.getId(), EXPECTED_ID);
        Assert.assertEquals(account.getLogin(), EXPECTED_LOGIN);
        Assert.assertEquals(account.getPassword(), EXPECTED_PASSWORD);
        Assert.assertEquals(account.getRole(), EXPECTED_ROLE);
    }
}
