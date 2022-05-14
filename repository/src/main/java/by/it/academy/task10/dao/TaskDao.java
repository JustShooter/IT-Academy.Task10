package by.it.academy.task10.dao;

import by.it.academy.task10.dao.Interfaces.TaskDaoInt;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.util.HibernateUtil;

public class TaskDao extends AbstractDAO<Task> implements TaskDaoInt {

    public TaskDao() {
        super(Task.class, HibernateUtil.getEntityManager());
    }
}
