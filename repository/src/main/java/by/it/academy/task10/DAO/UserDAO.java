package by.it.academy.task10.DAO;

import by.it.academy.task10.entity.User;
import by.it.academy.task10.util.HibernateUtil;

import java.sql.SQLException;

public class UserDAO extends AbstractDAO<User> {
    public UserDAO() {
        super(User.class, HibernateUtil.getEntityManager());
    }

    @Override
    public User findOne(Integer id) throws SQLException {
        return null;
    }

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public User update(User incomingEntity) {
        return null;
    }

    @Override
    public void delete(User entity) {
    }

    @Override
    public void deleteById(Integer entityId) throws SQLException {

    }



}
