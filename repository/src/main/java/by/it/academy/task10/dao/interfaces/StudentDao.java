package by.it.academy.task10.dao.interfaces;

import by.it.academy.task10.dao.GenericDAO;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.User;

public interface StudentDao extends GenericDAO<Student> {
    User getByName(String name, String surname);
}
