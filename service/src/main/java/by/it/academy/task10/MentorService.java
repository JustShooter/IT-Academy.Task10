package by.it.academy.task10;

import by.it.academy.task10.dao.*;
import by.it.academy.task10.dao.Interfaces.*;
import by.it.academy.task10.entity.*;

import java.sql.SQLException;
import java.util.Set;

public class MentorService {

    private MentorDaoInt mentorDao = new MentorDao();
    private CourseDaoInt courseDao = new CourseDao();
    private StudentDaoInt studentDao = new StudentDao();
    private TaskDaoInt taskDao = new TaskDao();
    private MarkReportDaoInt markReportDao = new MarkReportDao();
    private final UserDaoInt userDao = new UserDAO();


    public void createTask(String titleCourse, String titleTask) throws SQLException {
        Course course = courseDao.findOne(GeneralService.getIdCourse(titleCourse, courseDao));
        if (GeneralService.getIdTask(titleTask, taskDao) == null) {
            Task task = taskDao.create(Task.builder()
                    .title(titleTask)
                    .build());
            task.setTaskCourse(course);
            course.getTasks().add(task);
            courseDao.update(course);
            taskDao.update(task);
        }
    }

    public void deleteTask(String titleTask, String titleCourse) throws SQLException {
        taskDao.deleteById(GeneralService.getIdTask(titleTask, taskDao));
    }

    public void rateAndFeedbackStudentTask(String nameStudent, String surnameStudent,
                                           String titleTask, String titleCourse,
                                           Integer mark, String feedback) throws SQLException {
        Student student = studentDao.findOne(GeneralService.getIdUser(nameStudent, surnameStudent, userDao));
        Task task = taskDao.findOne(GeneralService.getIdTask(titleTask, taskDao));
        Mentor mentor = mentorDao.findOne(GeneralService.getIdMentorOfCourse(titleCourse, courseDao));
        Integer idReport = GeneralService.getIdReport(nameStudent, surnameStudent, titleTask,
                taskDao, studentDao, markReportDao,userDao);
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
