package by.it.academy.task10.services.interfaces;

import by.it.academy.task10.dao.GenericDAO;
import by.it.academy.task10.entity.*;

import java.sql.SQLException;

public interface GeneralService {
    static Integer getIdUser(String name, String surname, GenericDAO<User> userDao) {
        return null;
    }

    static Integer getIdTask(String taskTitle, GenericDAO<Task> taskDao) {
        return null;
    }

    static Integer getIdCourse(String courseTitle, GenericDAO<Course> courseDao) {
        return null;
    }

    static Integer getIdMentorOfCourse(String courseTitle, GenericDAO<Course> courseDao) {
        return null;
    }

    static Integer getIdTaskFromCourse(String titleT, String titleC,
                                       GenericDAO<Task> taskDao, GenericDAO<Course> courseDao) {
        return null;
    }

    static Integer getIdReport(String nameS, String surnameS,
                               String titleT, String titleC,
                               GenericDAO<Task> taskDao, GenericDAO<Student> studentDao,
                               GenericDAO<MarkReport> markReportDao,
                               GenericDAO<Course> courseDao, GenericDAO<User> userDao) throws SQLException {
        return null;
    }
}

