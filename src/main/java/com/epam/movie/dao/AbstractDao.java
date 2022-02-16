package com.epam.movie.dao;

import com.epam.movie.db.ProxyConnection;
import com.epam.movie.exception.DaoException;
import com.epam.movie.mapper.RowMapper;
import com.epam.movie.model.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Entity> {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDao.class);

    private final ProxyConnection proxyConnection;

    private static final String RETRIEVE_NUMBER_OF_RECORDS = "SELECT COUNT(*) FROM ";

    protected AbstractDao(ProxyConnection proxyConnection) {
        this.proxyConnection = proxyConnection;
    }

    //protected abstract List<T> retrieveAll();

    public int retrieveNumberOfRecords(String tableName) throws DaoException {
        try (final PreparedStatement statement = createStatement(RETRIEVE_NUMBER_OF_RECORDS + tableName)) {
            final ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int num = resultSet.getInt(1);
            return num;
        } catch (SQLException e) {
            LOG.error("", e.getMessage());
            throw new DaoException(e);
        }
    }
  public int retrieveNumberOfRecordsWhere(String query, Object... params) throws DaoException {
        try (final PreparedStatement statement = createStatement(query, params)) {
            final ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int num = resultSet.getInt(1);
            return num;
        } catch (SQLException e) {
            LOG.error("", e.getMessage());
            throw new DaoException(e);
        }
    }

    protected List<T> executeQuery(String query, RowMapper<T> mapper, Object... params) throws DaoException {
        try (final PreparedStatement statement = createStatement(query, params)) {
            List<T> entities = new ArrayList<>();
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            LOG.error("", e.getMessage());
            throw new DaoException(e);
        }
    }

    protected Optional<T> executeForSingleResult(String query, RowMapper<T> mapper, Object... params) throws DaoException {
        List<T> entities = executeQuery(query, mapper, params);
        T entity;
        if (entities.size() == 1) {
            return Optional.of(entities.get(0));
        } else if (entities.size() == 0) {
            return Optional.empty();
        }
        LOG.error("");
        throw new IllegalArgumentException("More than one element");
    }

    protected void executeUpdate(String query, Object... params) throws DaoException {
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.error("", e);
            throw new DaoException(e);
        }
    }

    //protected abstract void create(String query, Object... params);

    private PreparedStatement createStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = proxyConnection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            statement.setObject((i + 1), params[i]);
        }
        return statement;
    }
}
