package by.it.academy.task10.DAO;

import by.it.academy.task10.entity.Student;
import by.it.academy.task10.util.HibernateUtil;

public class StudentDao extends AbstractDAO<Student> {

    public StudentDao() {
        super(Student.class, HibernateUtil.getEntityManager());
    }
}
