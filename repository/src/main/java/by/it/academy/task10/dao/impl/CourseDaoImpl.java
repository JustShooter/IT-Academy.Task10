package by.it.academy.task10.dao.impl;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.interf.CourseDao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.util.HibernateUtil;

import javax.persistence.EntityManager;

public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {

    public CourseDaoImpl() {
        super(Course.class, HibernateUtil.getEntityManager());
    }
}
