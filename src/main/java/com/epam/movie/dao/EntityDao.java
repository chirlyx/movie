package com.epam.movie.dao;

import com.epam.movie.exception.DaoException;
import com.epam.movie.model.Entity;

import java.util.List;
import java.util.Optional;

public interface EntityDao<T extends Entity> {

    T create(T entity) throws DaoException;

    List<T> readAll();

    List<T> readWithLimit(int offset, int limit) throws DaoException;

    Optional<T> readById(int id) throws DaoException;

    T update(T entity);

    boolean delete(int id);
}
