package by.it.academy.task10.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> extends Serializable  {
    T findOne(Object id) throws SQLException;

    @SuppressWarnings("unchecked")
    List<T> findAll();

    T create(T entity);

    T update(T incomingEntity);

    void delete(T entity);

    void deleteById(long entityId) throws SQLException;

    void closeAll();
}
