package by.it.academy.task10;

import by.it.academy.task10.dao.CourseDao;
import by.it.academy.task10.dao.GenericDAO;
import by.it.academy.task10.dao.MarkReportDao;
import by.it.academy.task10.dao.MentorDao;
import by.it.academy.task10.dao.StudentDao;
import by.it.academy.task10.dao.TaskDao;
import by.it.academy.task10.dao.UserDAO;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.entity.User;


import java.sql.SQLException;
import java.util.Set;

public class MentorService {

    private GenericDAO<Mentor> mentorDao = new MentorDao();
    private GenericDAO<Course> courseDao = new CourseDao();
    private GenericDAO<Student> studentDao = new StudentDao();
    private GenericDAO<Task> taskDao = new TaskDao();
    private GenericDAO<MarkReport> markReportDao = new MarkReportDao();
    private final GenericDAO<User> userDao = new UserDAO();


    public void createTask(String titleCourse, String titleTask) throws SQLException {
        Integer idTaskFromCourse = GeneralService.getIdTaskFromCourse(titleTask, titleCourse, taskDao, courseDao);
        Integer idCourse = GeneralService.getIdCourse(titleCourse, courseDao);
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
        Integer idTaskFromCourse = GeneralService.getIdTaskFromCourse(titleTask, titleCourse, taskDao, courseDao);
        Task one = taskDao.findOne(idTaskFromCourse);
        taskDao.delete(one);

    }

    public void rateAndFeedbackStudentTask(String nameStudent, String surnameStudent,
                                           String titleTask, String titleCourse,
                                           Integer mark, String feedback) throws SQLException {

        Integer idStudent = GeneralService.getIdUser(nameStudent, surnameStudent, userDao);
        Student student = studentDao.findOne(idStudent);
        Integer idTaskFromCourse = GeneralService.getIdTaskFromCourse(titleTask, titleCourse, taskDao, courseDao);
        Task task = taskDao.findOne(idTaskFromCourse);
        Integer idMentorOfCourse = GeneralService.getIdMentorOfCourse(titleCourse, courseDao);
        Mentor mentor = mentorDao.findOne(idMentorOfCourse);
        Integer idReport = GeneralService.getIdReport(nameStudent, surnameStudent, titleTask, titleCourse,
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
        Integer idCourse = GeneralService.getIdCourse(titleCourse,courseDao);
        Course course = courseDao.findOne(idCourse);
        Set<Student> students = course.getStudents();
        if (students.size() != 0) {
            return students;
        } else {
            return null;
        }

    }

}
