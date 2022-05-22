package by.it.academy.task10.dao.interfaces;

import by.it.academy.task10.dao.GenericDAO;
import by.it.academy.task10.entity.User;

public interface UserDao extends GenericDAO<User> {

    User getUserByName(String name, String surname);

}
