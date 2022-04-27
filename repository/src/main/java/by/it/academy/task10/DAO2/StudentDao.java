package by.it.academy.task10.DAO2;

import by.it.academy.task10.entity.Student;
import by.it.academy.task10.util.HibernateUtil;

public class StudentDao extends DAOBase<Student> {

    public StudentDao() {
        super(Student.class, HibernateUtil.getEntityManager());
    }
}
