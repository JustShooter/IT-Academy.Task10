package by.it.academy.task10.dao.Interfaces;

import by.it.academy.task10.entity.Course;

public interface CourseDao extends GenericDAO<Course> {

    Course getCourseByTitle(String title);
}
