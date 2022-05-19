package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.util.HibernateUtil;

import javax.persistence.NoResultException;
import java.util.List;

public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {

    public CourseDaoImpl() {
        super(Course.class, HibernateUtil.getEntityManager());
    }

    @Override
    public Course getCourceByTitle(String title) {
        Course title1 = null;
        try {
            title1 = entityManager.createQuery("select c from Course c " +
                            "where c.title = :title", Course.class)
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (Exception ignored) {
        }
        return title1;
    }

    @Override
    public List<Course> getAllCoursesByMentorId(Integer mentorId) {
        return entityManager.createQuery("select c from Course c " +
                        "where c.mentor.id = :mentor", Course.class)
                .setParameter("mentor", mentorId)
                .getResultList();
    }

}
