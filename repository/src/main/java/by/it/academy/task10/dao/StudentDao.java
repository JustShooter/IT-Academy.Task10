package by.it.academy.task10.dao;

import by.it.academy.task10.dao.Interfaces.StudentDaoInt;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.User;
import by.it.academy.task10.util.HibernateUtil;

import javax.persistence.EntityManager;

public class StudentDao extends AbstractDAO<Student> implements StudentDaoInt {

    EntityManager em = HibernateUtil.getEntityManager();

    public StudentDao() {
        super(Student.class, HibernateUtil.getEntityManager());
    }

    @Override
    public User getByName(String name, String surname) {
        return em.createQuery("select s from User s where " +
                        "s.name = :userName and s.surname = :userSurname", User.class)
                .setParameter("userName", name)
                .setParameter("userSurname", surname)
                .getSingleResult();
    }
}
