package com.epam.movie.mapper;

import com.epam.movie.model.Entity;
import com.epam.movie.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper{
    @Override
    public Entity map(ResultSet resultSet) throws SQLException {
        final Integer id = resultSet.getInt("id");
        final String title = resultSet.getString("title");
        final Integer year = resultSet.getInt("year");
        final Integer categoryId = resultSet.getInt("category_id");
        final String description = resultSet.getString("description");
        final Boolean deleted = resultSet.getBoolean("deleted");
        return new Movie(id, title, year, categoryId, description, deleted);
    }
}
