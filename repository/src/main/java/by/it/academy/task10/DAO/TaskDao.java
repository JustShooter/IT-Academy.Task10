package by.it.academy.task10.DAO;

import by.it.academy.task10.entity.Task;
import by.it.academy.task10.util.HibernateUtil;

public class TaskDao extends AbstractDAO<Task> {

    public TaskDao() {
        super(Task.class, HibernateUtil.getEntityManager());
    }
}
