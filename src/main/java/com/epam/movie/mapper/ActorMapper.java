package com.epam.movie.mapper;

import com.epam.movie.model.Actor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements RowMapper<Actor>{
    @Override
    public Actor map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("actor_id");
        String name = resultSet.getString("a_name");
        return new Actor(id, name);
    }
}
