package com.epam.movie.mapper;

import com.epam.movie.model.Entity;
import com.epam.movie.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper{
    @Override
    public Entity map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        Integer year = resultSet.getInt("year");
        Integer categoryId = resultSet.getInt("category_id");
        String description = resultSet.getString("description");
        return new Movie(id, title, year, categoryId, description);
    }
}
