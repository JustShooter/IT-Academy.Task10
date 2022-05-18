package by.it.academy.task10.dao.implementations;


import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.Interfaces.UserDao;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.User;
import by.it.academy.task10.util.HibernateUtil;

import java.util.Optional;

public class UserDAOImpl extends GenericDaoImpl<User> implements UserDao {
    public UserDAOImpl() {
        super(User.class, HibernateUtil.getEntityManager());
    }

    @Override
    public User getUserByName(String name, String surname) {
        User singleResult = null;
        try {
            singleResult = entityManager.createQuery("select s from User s where " +
                            "s.name = :userName and s.surname = :userSurname", User.class)
                    .setParameter("userName", name)
                    .setParameter("userSurname", surname)
                    .getSingleResult();
        } catch (Exception e) {
        }
        return singleResult;

    }


}
