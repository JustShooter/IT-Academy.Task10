package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.GenericDAO;
import by.it.academy.task10.entity.*;
import by.it.academy.task10.services.interfaces.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class GeneralServiceImpl implements GeneralService {


    static Integer getIdUser(String name, String surname, GenericDAO<User> userDao) {
        return userDao.findAll().stream()
                .filter(st -> st.getName().equals(name) && st.getSurname().equals(surname))
                .map(User::getId)
                .findFirst().orElse(null);
    }


    static Integer getIdTask(String taskTitle, GenericDAO<Task> taskDao) {
        List<Task> allTasks = taskDao.findAll();
        Task task = allTasks.stream()
                .filter(t -> t.getTitle().equals(taskTitle))
                .findAny().orElse(null);
        if (task != null) {
            return task.getId();
        } else {
            return null;
        }
    }

    static Integer getIdCourse(String courseTitle, GenericDAO<Course> courseDao) {
        List<Course> allCourses = courseDao.findAll();
        Course course = allCourses.stream()
                .filter(c -> c.getTitle().equals(courseTitle))
                .findAny()
                .orElse(null);
        if (course != null) {
            return course.getId();
        } else {
            return null;
        }
    }

    static Integer getIdMentorOfCourse(String courseTitle, GenericDAO<Course> courseDao) {
        List<Course> allCourses = courseDao.findAll();
        Course course = allCourses.stream()
                .filter(m -> m.getTitle().equals(courseTitle))
                .findAny().orElse(null);
        if (course != null) {
            return course.getMentor().getId();
        } else {
            return null;
        }
    }

    static Integer getIdTaskFromCourse(String titleT, String titleC, GenericDAO<Task> taskDao, GenericDAO<Course> courseDao) {
        List<Task> allTasks = taskDao.findAll();
        List<Course> allCourses = courseDao.findAll();
        Course course = allCourses.stream()
                .filter(c -> c.getTitle().equals(titleC)).findFirst().orElse(null);
        Task task = allTasks.stream().filter(t -> t.getTaskCourse().equals(course)).findAny().orElse(null);
        if (task != null) {
            return task.getId();
        } else {
            return null;
        }
    }

    static Integer getIdReport(String nameS, String surnameS,
                               String titleT, String titleC,
                               GenericDAO<Task> taskDao, GenericDAO<Student> studentDao,
                               GenericDAO<MarkReport> markReportDao,
                               GenericDAO<Course> courseDao, GenericDAO<User> userDao) throws SQLException {
        Integer idTaskFromCourse = getIdTaskFromCourse(titleT, titleC, taskDao, courseDao);
        Task task = taskDao.findOne(idTaskFromCourse);
        Integer idStudent = getIdUser(nameS, surnameS, userDao);
        Student student = studentDao.findOne(idStudent);
        List<MarkReport> allReports = markReportDao.findAll();
        if (allReports.size() != 0) {
            MarkReport markReport = allReports.stream()
                    .filter(r -> r.getStudent().equals(student) && r.getTask().equals(task))
                    .findAny().orElse(null);
            return markReport.getId();
        } else {
            return null;
        }
    }

}