package by.it.academy.task10.dao.interfaces;

import by.it.academy.task10.dao.GenericDAO;
import by.it.academy.task10.entity.Mentor;
import javax.persistence.NoResultException;

public interface MentorDao extends GenericDAO<Mentor> {

    Mentor getMentorIdByFullName(String name, String surname) throws NoResultException;
}
