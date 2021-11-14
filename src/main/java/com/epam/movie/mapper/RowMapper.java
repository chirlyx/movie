package com.epam.movie.mapper;

import com.epam.movie.model.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Entity> {
    T map(ResultSet resultSet) throws SQLException;
}
