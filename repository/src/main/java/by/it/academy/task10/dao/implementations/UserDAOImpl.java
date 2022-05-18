package by.it.academy.task10.dao.implementations;


import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.Interfaces.UserDao;
import by.it.academy.task10.entity.User;
import by.it.academy.task10.util.HibernateUtil;

public class UserDAOImpl extends GenericDaoImpl<User> implements UserDao {
    public UserDAOImpl() {
        super(User.class, HibernateUtil.getEntityManager());
    }



}
