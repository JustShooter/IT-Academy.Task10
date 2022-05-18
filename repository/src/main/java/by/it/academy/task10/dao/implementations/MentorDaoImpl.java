package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.Interfaces.MentorDao;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.util.HibernateUtil;

public class MentorDaoImpl extends GenericDaoImpl<Mentor> implements MentorDao {

    public MentorDaoImpl() {
        super(Mentor.class, HibernateUtil.getEntityManager());
    }

    @Override
    public Mentor getMentorByName(String name, String surname) {
        Mentor singleResult = null;
        try {
            singleResult = entityManager.createQuery("select m from Mentor m " +
                            "where m.name = :mentorName and m.surname = :mentorSurname", Mentor.class)
                    .setParameter("mentorName", name)
                    .setParameter("mentorSurname", surname)
                    .getSingleResult();
        } catch (Exception e) {
        }
        return singleResult;
    }
}
