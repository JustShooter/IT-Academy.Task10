package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.interfaces.MentorDao;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.util.HibernateUtil;
import javax.persistence.NoResultException;

public class MentorDaoImpl extends GenericDaoImpl<Mentor> implements MentorDao {

    public MentorDaoImpl() {
        super(Mentor.class, HibernateUtil.getEntityManager());
    }

    @Override
    public Mentor getMentorIdByFullName(String name, String surname) throws NoResultException {
        return (Mentor) entityManager.createQuery("select m from Mentor m " +
                "where m.name = :name and " +
                "m.surname = :surname")
                .setParameter("name" , name)
                .setParameter("surname", surname)
                .getSingleResult();
    }

}
