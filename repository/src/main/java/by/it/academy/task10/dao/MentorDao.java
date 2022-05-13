package by.it.academy.task10.dao;

import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.util.HibernateUtil;

public class MentorDao extends AbstractDAO<Mentor> {

    public MentorDao() {
        super(Mentor.class, HibernateUtil.getEntityManager());
    }

}
