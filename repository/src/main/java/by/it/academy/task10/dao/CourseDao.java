package by.it.academy.task10.dao;

import by.it.academy.task10.entity.Course;
import by.it.academy.task10.util.HibernateUtil;

public class CourseDao extends AbstractDAO<Course> {

    public CourseDao() {
        super(Course.class, HibernateUtil.getEntityManager());
    }
}
