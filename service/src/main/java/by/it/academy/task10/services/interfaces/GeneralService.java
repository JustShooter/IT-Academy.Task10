package by.it.academy.task10.services.interfaces;

import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.interfaces.MarkReportDao;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.dao.interfaces.TaskDao;
import by.it.academy.task10.dao.interfaces.UserDao;

import java.sql.SQLException;

public interface GeneralService {
    Integer getIdUser(String name, String surname, UserDao userDao) ;

    Integer getIdTask(String taskTitle, TaskDao taskDao);

    Integer getIdCourse(String courseTitle, CourseDao courseDao);

    Integer getIdMentorOfCourse(String courseTitle, CourseDao courseDao);

    Integer getIdReport(String nameS, String surnameS,
                               String titleT,
                               TaskDao taskDao, StudentDao studentDao,
                               MarkReportDao markReportDao,
                               UserDao userDao) throws SQLException;
}

