package by.it.academy.task10;

import by.it.academy.task10.entity.Task;
import by.it.academy.task10.dao.implementations.TaskDaoImpl;
import by.it.academy.task10.dao.interfaces.TaskDao;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.MockConstants.*;
import static org.junit.Assert.*;

public class TaskDaoTest {



    private final TaskDao taskDao = new TaskDaoImpl();

    @Test
    public void create() throws SQLException {
        Task task = Task.builder()
                .title(TITLE_1)
                .build();
        taskDao.create(task);
        Task actualTask = taskDao.findOne(task.getId());
        assertNotNull(actualTask);
        assertEquals(task.getTitle(), actualTask.getTitle());
    }

    @Test
    public void findOne() throws SQLException {
        Task task = Task.builder()
                .title(TITLE_2)
                .build();
        taskDao.create(task);
        Task actualTask = taskDao.findOne(task.getId());
        assertNotNull(actualTask);
        assertEquals(task.getTitle(), actualTask.getTitle());
    }

    @Test
    public void findAll() throws SQLException {
        Task task = Task.builder()
                .title(TITLE_3)
                .build();
        taskDao.create(task);
        List<Task> all = taskDao.findAll();
        Task actualTask = all.stream()
                .filter(aS -> aS.getTitle().equals(task.getTitle()))
                .findAny().orElse(null);
        assertNotNull(actualTask);
        assertEquals(task.getTitle(), actualTask.getTitle());
    }

    @Test
    public void update() {
        Task task = Task.builder()
                .title(TITLE_4)
                .build();
        taskDao.create(task);
        task.setTitle(TITLE_1);
        taskDao.update(task);
        assertEquals(task.getTitle(), TITLE_1);
    }

    @Test
    public void delete() throws SQLException {
        Task task = Task.builder()
                .title(C)
                .build();
        taskDao.create(task);
        taskDao.delete(task);
        List<Task> all = taskDao.findAll();
        Task actualTask = all.stream()
                .filter(aS -> aS.getTitle().equals(task.getTitle()))
                .findAny().orElse(null);
        assertNull(actualTask);
    }

    @Test
    public void deleteById() throws SQLException {
        Task task = Task.builder()
                .title(C)
                .build();
        taskDao.create(task);
        Integer id = task.getId();
        taskDao.deleteById(id);
        List<Task> all = taskDao.findAll();
        Task actualTask = all.stream()
                .filter(aS -> aS.getTitle().equals(task.getTitle()))
                .findAny().orElse(null);
        assertNull(actualTask);
    }

}