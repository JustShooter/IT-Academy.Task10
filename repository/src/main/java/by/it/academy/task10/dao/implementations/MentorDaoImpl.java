package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.interfaces.MentorDao;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.util.HibernateUtil;

public class MentorDaoImpl extends GenericDaoImpl<Mentor> implements MentorDao {

    public MentorDaoImpl() {
        super(Mentor.class, HibernateUtil.getEntityManager());
    }

}
