package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.interfaces.MarkReportDao;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.dao.interfaces.TaskDao;
import by.it.academy.task10.dao.interfaces.UserDao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.entity.User;
import by.it.academy.task10.services.interfaces.GeneralService;

import java.sql.SQLException;
import java.util.List;

public class GeneralServiceImpl implements GeneralService {

    public Integer getIdUser(String name, String surname, UserDao userDao) {
        return userDao.getUserByName(name, surname) != null ?
                userDao.getUserByName(name, surname).getId() : null;
    }

    @Override
    public Integer getIdTask(String taskTitle, TaskDao taskDao) {
        return taskDao.findAll().stream()
                .filter(t -> taskTitle.equals(t.getTitle()))
                .map(Task::getId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Integer getIdCourse(String courseTitle, CourseDao courseDao) {
        return courseDao.findAll().stream()
                .filter(c -> courseTitle.equals(c.getTitle()))
                .map(Course::getId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Integer getIdMentorOfCourse(String courseTitle, CourseDao courseDao) {
        return courseDao.findAll().stream()
                .filter(m -> courseTitle.equals(m.getTitle()))
                .findFirst()
                .map(Course::getMentor)
                .map(Mentor::getId)
                .orElse(null);
    }

    @Override
    public Integer getIdReport(String nameS, String surnameS,
                                      String titleT,
                                      TaskDao taskDao, StudentDao studentDao,
                                      MarkReportDao markReportDao,
                                      UserDao userDao) throws SQLException {
        Task task = taskDao.findOne(getIdTask(titleT, taskDao));
        Student student = studentDao.findOne(getIdUser(nameS, surnameS, userDao));
        List<MarkReport> allReports = markReportDao.findAll();
        if (!allReports.isEmpty()) {
            MarkReport markReport = allReports.stream()
                    .filter(r -> r.getStudent().equals(student) && r.getTask().equals(task))
                    .findAny().orElse(null);
            return (markReport == null) ? null : markReport.getId();
        } else {
            return null;
        }
    }

}
