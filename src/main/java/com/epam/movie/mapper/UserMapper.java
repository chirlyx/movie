package com.epam.movie.mapper;

import com.epam.movie.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("user_id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        Integer statusId = resultSet.getInt("status_id");
        Integer banStatusId = resultSet.getInt("ban_status_id");
        return new User(id, firstName, lastName, statusId, banStatusId);
    }
}
