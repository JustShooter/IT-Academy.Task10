package by.it.academy.task10.dao.Interfaces;

import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.User;

public interface StudentDaoInt extends GenericDAO<Student> {

    User getByName(String name, String surname);
}
