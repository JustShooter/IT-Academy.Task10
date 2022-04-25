package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.*;

import java.sql.SQLException;
import java.util.List;

public class GeneralService {

    private static Dao<User> userDao = new Dao<>(User.class);
    private static Dao<Student> studentDao = new Dao<>(Student.class);
    private static Dao<Course> courseDao = new Dao<>(Course.class);
    private static Dao<Task> taskDao = new Dao<>(Task.class);
    private static Dao<MarkReport> markReportDao = new Dao<>(MarkReport.class);

    static Integer getIdUser(String name, String surname) {
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

    static Integer getIdTask(String taskTitle) {
        List<Task> allTasks = taskDao.findAll();
        Task task = allTasks.stream().filter(t -> t.getTitle().equals(taskTitle))
                .findAny().orElse(null);
        if (task != null) {
            return task.getId();
        } else {
            return null;
        }
    }

    static Integer getIdCourse(String courseTitle) {
        List<Course> allCourses = courseDao.findAll();
        Course course = allCourses.stream().filter(c -> c.getTitle().equals(courseTitle))
                .findAny().orElse(null);
        if (course != null) {
            return course.getId();
        } else {
            return null;
        }
    }

    static Integer getIdMentorOfCourse(String courseTitle) {
        List<Course> allCourses = courseDao.findAll();
        Course course = allCourses.stream()
                .filter(m -> m.getTitle().equals(courseTitle)).findAny().orElse(null);
        if (course != null) {
            return course.getMentorCourse().getId();
        } else {
            return null;
        }
    }

    static Integer getIdTaskFromCourse(String titleT, String titleC) {
        List<Task> allTasks = taskDao.findAll();
        List<Course> allCourses = courseDao.findAll();
        Course course = allCourses.stream().filter(c -> c.getTitle().equals(titleC)).findFirst().orElse(null);
        Task task = allTasks.stream().filter(t -> t.getTaskCourse().equals(course)).findAny().orElse(null);
        if (task != null) {
            return task.getId();
        } else {
            return null;
        }
    }

//    static Integer getIdReport(String nameS, String surnameS,
//                               String titleT, String titleC) throws SQLException {
//        Integer idTaskFromCourse = getIdTaskFromCourse(titleT, titleC);
//        Task task = taskDao.findOne(idTaskFromCourse);
//        Integer idStudent = getIdUser(nameS, surnameS);
//        Student student = studentDao.findOne(idStudent);
//        List<MarkReport> allReports = markReportDao.findAll();
//        if (allReports.size() != 0) {
//            MarkReport markReport = allReports.stream()
//                    .filter(r -> r.getStudent().equals(student) && r.getTask().equals(task))
//                    .findAny().orElse(null);
//            return markReport.getId();
//        } else {
//            return null;
//        }
//
//
//    }

}
