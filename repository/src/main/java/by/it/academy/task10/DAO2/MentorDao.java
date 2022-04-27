package by.it.academy.task10.DAO2;

import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.util.HibernateUtil;

public class MentorDao extends DAOBase<Mentor> {

    public MentorDao() {
        super(Mentor.class, HibernateUtil.getEntityManager());
    }

}
