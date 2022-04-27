package by.it.academy.task10.DAO2;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    T findOne(Integer id) throws SQLException;

    @SuppressWarnings("unchecked")
    List<T> findAll();

    T create(T entity);

    T update(T incomingEntity);

    void delete(T entity);

    void deleteById(Integer entityId) throws SQLException;

    void closeAll();
}
