package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.implementations.*;
import by.it.academy.task10.dao.interfaces.*;
import by.it.academy.task10.entity.*;
import by.it.academy.task10.services.interfaces.MentorService;

import java.sql.SQLException;
import java.util.Set;

public class MentorServiceImpl implements MentorService {

    private static MentorDao mentorDao = new MentorDaoImpl();
    private static CourseDao courseDao = new CourseDaoImpl();
    private static StudentDao studentDao = new StudentDaoImpl();
    private static TaskDao taskDao = new TaskDaoImpl();
    private static MarkReportDao markReportDao = new MarkReportDaoImpl();
    private static UserDao userDao = new UserDAOImpl();


    public void createTask(String titleCourse, String titleTask) throws SQLException {
        Integer idTaskFromCourse = GeneralServiceImpl.getIdTaskFromCourse(titleTask, titleCourse, taskDao, courseDao);
        Integer idCourse = GeneralServiceImpl.getIdCourse(titleCourse, courseDao);
        Course course = courseDao.findOne(idCourse);
        if (idTaskFromCourse == null) {
            Task task = taskDao.create(Task.builder()
                    .title(titleTask)
                    .build());
            task.setTaskCourse(course);
            taskDao.update(task);
        } else {
            System.out.println("Task already exist");
        }

    }

    public void deleteTask(String titleTask, String titleCourse) throws SQLException {
        Integer idTaskFromCourse = GeneralServiceImpl.getIdTaskFromCourse(titleTask, titleCourse, taskDao, courseDao);
        Task one = taskDao.findOne(idTaskFromCourse);
        taskDao.delete(one);

    }

    public void rateAndFeedbackStudentTask(String nameStudent, String surnameStudent,
                                           String titleTask, String titleCourse,
                                           Integer mark, String feedback) throws SQLException {

        Integer idStudent = GeneralServiceImpl.getIdUser(nameStudent, surnameStudent, userDao);
        Student student = studentDao.findOne(idStudent);
        Integer idTaskFromCourse = GeneralServiceImpl.getIdTaskFromCourse(titleTask, titleCourse, taskDao, courseDao);
        Task task = taskDao.findOne(idTaskFromCourse);
        Integer idMentorOfCourse = GeneralServiceImpl.getIdMentorOfCourse(titleCourse, courseDao);
        Mentor mentor = mentorDao.findOne(idMentorOfCourse);
        Integer idReport = GeneralServiceImpl.getIdReport(nameStudent, surnameStudent, titleTask, titleCourse,
                taskDao, studentDao, markReportDao, courseDao,userDao);
        if (idReport == null) {
            MarkReport markReport = MarkReport.builder()
                    .mentor(mentor)
                    .student(student)
                    .task(task)
                    .mark(mark)
                    .feedback(feedback)
                    .build();

            markReportDao.create(markReport);
        } else {
            MarkReport markReport = markReportDao.findOne(idReport);
            markReport.setMark(mark);
            markReport.setFeedback(feedback);
            markReportDao.update(markReport);
        }
    }

    public Set<Student> findStudentsOfCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralServiceImpl.getIdCourse(titleCourse,courseDao);
        Course course = courseDao.findOne(idCourse);
        Set<Student> students = course.getStudents();
        if (students.size() != 0) {
            return students;
        } else {
            return null;
        }

    }

}
