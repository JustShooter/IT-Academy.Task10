package by.it.academy.task10.services.interfaces;

import by.it.academy.task10.dao.Interfaces.*;

import java.sql.SQLException;

public interface GeneralService {
    static Integer getIdUser(String name, String surname, UserDao userDao) {
        return null;
    }

    static Integer getIdTask(String taskTitle, TaskDao taskDao) {
        return null;
    }

    static Integer getIdCourse(String courseTitle, CourseDao courseDao) {
        return null;
    }

    static Integer getIdMentorOfCourse(String courseTitle, CourseDao courseDao) {
        return null;
    }

    static Integer getIdReport(String nameS, String surnameS,
                               String titleT,
                               TaskDao taskDao, StudentDao studentDao,
                               MarkReportDao markReportDao,
                               UserDao userDao) throws SQLException {
        return null;
    }
}

