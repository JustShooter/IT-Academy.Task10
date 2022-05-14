package by.it.academy.task10.dao.impl;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.interf.StudentDao;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.util.HibernateUtil;

public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao {

    public StudentDaoImpl() {
        super(Student.class, HibernateUtil.getEntityManager());
    }
}
