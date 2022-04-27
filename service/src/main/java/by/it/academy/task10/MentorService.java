package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.*;

import java.sql.SQLException;
import java.util.Set;

public class MentorService {

    private Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);
    private Dao<User> userDao = new Dao<User>(User.class);
    private Dao<Student> studentDao = new Dao<>(Student.class);
    private Dao<Task> taskDao = new Dao<>(Task.class);
    private Dao<MarkReport> markReportDao = new Dao<>(MarkReport.class);


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
                taskDao, studentDao, markReportDao, courseDao, userDao);
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
