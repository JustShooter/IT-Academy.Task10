package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.util.HibernateUtil;

public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao {

    public StudentDaoImpl() {
        super(Student.class, HibernateUtil.getEntityManager());
    }
}
