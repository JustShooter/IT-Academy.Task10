package by.it.academy.task10.dao.interfaces;

import by.it.academy.task10.dao.GenericDAO;
import by.it.academy.task10.entity.Course;

public interface CourseDao extends GenericDAO<Course> {
    Course getCourceByTitle(String title);
}
