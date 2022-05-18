package by.it.academy.task10.dao.Interfaces;

import by.it.academy.task10.entity.Mentor;

public interface MentorDao extends GenericDAO<Mentor> {

    Mentor getMentorByName(String name, String surname);
}
