package by.it.academy.task10.dao.Interfaces;

import by.it.academy.task10.entity.Task;

public interface TaskDao extends GenericDAO<Task> {

    Task getTaskByTitle(String title);
}
