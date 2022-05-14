package by.it.academy.task10.dao.impl;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.interf.UserDao;
import by.it.academy.task10.entity.User;
import by.it.academy.task10.util.HibernateUtil;

public class UserDAO extends GenericDaoImpl<User> implements UserDao {
    public UserDAO() {
        super(User.class, HibernateUtil.getEntityManager());
    }

//    @Override
//    public User findOne(Integer id) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public User create(User entity) {
//        return null;
//    }
//
//    @Override
//    public User update(User incomingEntity) {
//        return null;
//    }
//
//    @Override
//    public void delete(User entity) {
//    }
//
//    @Override
//    public void deleteById(Integer entityId) throws SQLException {
//
//    }


}
