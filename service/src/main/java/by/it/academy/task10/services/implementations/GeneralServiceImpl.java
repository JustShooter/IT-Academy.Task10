package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.Interfaces.*;
import by.it.academy.task10.entity.*;
import by.it.academy.task10.services.interfaces.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class GeneralServiceImpl implements GeneralService {

    public static Integer getIdUser(String name, String surname, UserDao userDao) {
        return userDao.getUserByName(name, surname) != null ?
                userDao.getUserByName(name, surname).getId() : null;
    }


    public static Integer getIdTask(String taskTitle, TaskDao taskDao) {
        return taskDao.getTaskByTitle(taskTitle) != null ?
                taskDao.getTaskByTitle(taskTitle).getId() : null;
    }

    public static Integer getIdCourse(String courseTitle, CourseDao courseDao) {
        return courseDao.getCourseByTitle(courseTitle) != null ?
                courseDao.getCourseByTitle(courseTitle).getId() : null;
    }

    public static Integer getIdMentorOfCourse(String courseTitle, CourseDao courseDao) {
        return courseDao.getCourseByTitle(courseTitle).getMentor() != null ?
                courseDao.getCourseByTitle(courseTitle).getMentor().getId() : null;
    }

    public static Integer getIdReport(String nameS, String surnameS,
                                      String titleT,
                                      TaskDao taskDao, StudentDao studentDao,
                                      MarkReportDao markReportDao,
                                      UserDao userDao) throws SQLException {
        Task task = taskDao.findOne(getIdTask(titleT, taskDao));
        Student student = studentDao.findOne(GeneralServiceImpl.getIdUser(nameS, surnameS, userDao));
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
