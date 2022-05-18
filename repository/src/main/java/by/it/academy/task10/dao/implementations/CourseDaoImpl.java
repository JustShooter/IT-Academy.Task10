package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.Interfaces.CourseDao;
import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.util.HibernateUtil;

public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {

    public CourseDaoImpl() {
        super(Course.class, HibernateUtil.getEntityManager());
    }
}
