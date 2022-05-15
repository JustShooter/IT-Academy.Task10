package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.interfaces.TaskDao;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.util.HibernateUtil;

public class TaskDaoImpl extends GenericDaoImpl<Task> implements TaskDao {

    public TaskDaoImpl() {
        super(Task.class, HibernateUtil.getEntityManager());
    }
}
