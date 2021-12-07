package com.epam.movie.mapper;

import com.epam.movie.model.Review;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewMapper implements RowMapper<Review> {

    @Override
    public Review map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer userId = resultSet.getInt("user_id");
        Integer movieId = resultSet.getInt("movie_id");
        Integer mark = resultSet.getInt("mark");
        String comment = resultSet.getString("comment");
        return new Review(id, userId, movieId, mark, comment);
    }
}
