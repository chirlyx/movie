package com.epam.movie.mapper;

import com.epam.movie.model.Review;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewMapper implements RowMapper<Review> {

    @Override
    public Review map(ResultSet resultSet) throws SQLException {
        final Integer id = resultSet.getInt("id");
        final Integer userId = resultSet.getInt("user_id");
        final Integer movieId = resultSet.getInt("movie_id");
        final Integer mark = resultSet.getInt("mark");
        final String comment = resultSet.getString("comment");
        return new Review(id, userId, movieId, mark, comment);
    }
}
