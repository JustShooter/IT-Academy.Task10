package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.entity.User;

import java.util.List;

public class GeneralService {

    private Dao<User> userDao = new Dao<>(User.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);
    private Dao<Task> taskDao = new Dao<>(Task.class);

    Integer getIdUser(String name, String surname) {
        List<User> allUsers = userDao.findAll();
        User user = allUsers.stream()
                .filter(st -> st.getName().equals(name) && st.getSurname().equals(surname))
                .findAny().orElse(null);
        if (user != null) {
            return user.getId();
        } else {
            return null;
        }

    }

    Integer getIdTask(String taskTitle){
        List<Task> allTasks = taskDao.findAll();
        Task task = allTasks.stream().filter(t -> t.getTitle().equals(taskTitle))
                .findAny().orElse(null);
        if (task != null){
            return task.getId();
        }else {
            return null;
        }
    }

    Integer getIdCourse(String courseTitle){
        List<Course> allCourses = courseDao.findAll();
        Course course = allCourses.stream().filter(c -> c.getTitle().equals(courseTitle))
                .findAny().orElse(null);
        if (course != null){
            return course.getId();
        }else {
            return null;
        }
    }

    Integer getIdTaskFromCourse(String titleT, String titleC){
        List<Task> allTasks = taskDao.findAll();
        List<Course> allCourses = courseDao.findAll();
        Course course = allCourses.stream().filter(c -> c.getTitle().equals(titleC)).findFirst().orElse(null);
        Task task = allTasks.stream().filter(t -> t.getTaskCourse().equals(course)).findAny().orElse(null);
        if (task != null){
            return task.getId();
        }else {
            return null;
        }
    }

}
