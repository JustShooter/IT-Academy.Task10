package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.Interfaces.StudentDao;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.User;
import by.it.academy.task10.util.HibernateUtil;

public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao {

    public StudentDaoImpl() {
        super(Student.class, HibernateUtil.getEntityManager());
    }

    @Override
    public Student getByName(String name, String surname) {
        Student singleResult = null;
        try {
            singleResult = entityManager.createQuery("select s from User s where " +
                            "s.name = :userName and s.surname = :userSurname", Student.class)
                    .setParameter("userName", name)
                    .setParameter("userSurname", surname)
                    .getSingleResult();
        } catch (Exception e) {

        }
        return singleResult;
    }
}
