package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.Interfaces.TaskDao;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.util.HibernateUtil;

public class TaskDaoImpl extends GenericDaoImpl<Task> implements TaskDao {

    public TaskDaoImpl() {
        super(Task.class, HibernateUtil.getEntityManager());
    }

    @Override
    public Task getTaskByTitle(String title) {
        Task title1 = null;
        try {
            title1 = entityManager.createQuery("select t from Task t " +
                            "where t.title = :title", Task.class)
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (Exception e) {
        }
        return title1;
    }
}
