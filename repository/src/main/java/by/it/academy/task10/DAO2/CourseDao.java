package by.it.academy.task10.DAO2;

import by.it.academy.task10.entity.Course;
import by.it.academy.task10.util.HibernateUtil;

public class CourseDao extends DAOBase<Course> {

    public CourseDao() {
        super(Course.class, HibernateUtil.getEntityManager());
    }
}
