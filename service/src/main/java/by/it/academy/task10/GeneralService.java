package by.it.academy.task10;

import by.it.academy.task10.dao.Interfaces.*;
import by.it.academy.task10.entity.*;

import java.sql.SQLException;
import java.util.List;

public class GeneralService {


    static Integer getIdUser(String name, String surname, UserDaoInt userDao) {
        return userDao.findAll().stream()
                .filter(st -> name.equals(st.getName()) && surname.equals(st.getSurname()))
                .map(User::getId)
                .findFirst()
                .orElse(null);
    }


    static Integer getIdTask(String taskTitle, TaskDaoInt taskDao) {
        return taskDao.findAll().stream()
                .filter(t -> taskTitle.equals(t.getTitle()))
                .map(Task::getId)
                .findFirst()
                .orElse(null);
    }

    static Integer getIdCourse(String courseTitle, CourseDaoInt courseDao) {
        return courseDao.findAll().stream()
                .filter(c -> courseTitle.equals(c.getTitle()))
                .map(Course::getId)
                .findFirst()
                .orElse(null);
    }

    static Integer getIdMentorOfCourse(String courseTitle, CourseDaoInt courseDao) {
        return courseDao.findAll().stream()
                .filter(m -> courseTitle.equals(m.getTitle()))
                .findFirst()
                .map(Course::getMentor)
                .map(Mentor::getId)
                .orElse(null);
    }

 /*   static Integer getIdTaskFromCourse(String titleT, String titleC, GenericDAO<Task> taskDao, GenericDAO<Course> courseDao) {
        List<Task> allTasks = taskDao.findAll();
        List<Course> allCourses = courseDao.findAll();
        Course course = allCourses.stream()
                .filter(c -> c.getTitle().equals(titleC)).findFirst().orElse(null);
        Task task = allTasks.stream().
                filter(t -> t.getTaskCourse().equals(course)).findAny().orElse(null);
        if (task != null) {
            return task.getId();
        } else {
            return null;
        }
    }*/

    static Integer getIdReport(String nameS, String surnameS,
                               String titleT,
                               TaskDaoInt taskDao, StudentDaoInt studentDao,
                               MarkReportDaoInt markReportDao,
                               UserDaoInt userDao) throws SQLException {
        Task task = taskDao.findOne(getIdTask(titleT, taskDao));
        Student student = studentDao.findOne(getIdUser(nameS, surnameS, userDao));
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
