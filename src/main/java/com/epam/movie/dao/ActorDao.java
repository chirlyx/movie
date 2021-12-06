package com.epam.movie.dao;

import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;
import com.epam.movie.mapper.ActorMapper;
import com.epam.movie.model.Actor;

import java.util.List;
import java.util.Optional;

public class ActorDao extends AbstractDao<Actor> implements EntityDao<Actor> {
    private static final String READ_ACTORS_BY_ID = "SELECT movie_to_actor.actor_id, actor.a_name FROM actor JOIN movie_to_actor ON actor.id = movie_to_actor.actor_id WHERE movie_to_actor.movie_id = ?";

    protected ActorDao(ProxyConnection proxyConnection) {
        super(proxyConnection);
    }

    public List<Actor> read(int id) throws DaoException {
        return executeQuery(READ_ACTORS_BY_ID, new ActorMapper(), id);
    }

    @Override
    public Actor create(Actor entity) throws DaoException {
        return null;
    }

    @Override
    public List<Actor> readAll() {
        return null;
    }

    @Override
    public List<Actor> readWithLimit(int offset, int limit) throws DaoException {
        return null;
    }

    @Override
    public Optional<Actor> readById(int id) throws DaoException {
        return null;
    }

    @Override
    public Actor update(Actor entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
