package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.*;

import java.sql.SQLException;
import java.util.Set;

public class MentorService {

    private Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);
    private Dao<Student> studentDao = new Dao<>(Student.class);
    private Dao<Task> taskDao = new Dao<>(Task.class);
    private Dao<MarkReport> markReportDao = new Dao<>(MarkReport.class);


    public void createTask(String titleCourse, String titleTask) throws SQLException {
        Integer idTaskFromCourse = GeneralService.getIdTaskFromCourse(titleTask, titleCourse);
        Integer idCourse = GeneralService.getIdCourse(titleCourse);
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
        Integer idTaskFromCourse = GeneralService.getIdTaskFromCourse(titleTask, titleCourse);
        Task one = taskDao.findOne(idTaskFromCourse);
        taskDao.delete(one);

    }

    public void rateAndFeedbackStudentTask(String nameStudent, String surnameStudent,
                                           String titleTask, String titleCourse,
                                           Integer mark, String feedback) throws SQLException {

        Integer idStudent = GeneralService.getIdUser(nameStudent, surnameStudent);
        Student student = studentDao.findOne(idStudent);
        Integer idTaskFromCourse = GeneralService.getIdTaskFromCourse(titleTask, titleCourse);
        Task task = taskDao.findOne(idTaskFromCourse);
        Integer idMentorOfCourse = GeneralService.getIdMentorOfCourse(titleCourse);
        Mentor mentor = mentorDao.findOne(idMentorOfCourse);
        MarkReport markReport = markReportDao.create(MarkReport.builder()
//                    .student(student)
                .feedback(feedback)
                .mark(mark)
//                    .task(task)
//                    .mentor(mentor)
                .build());

        markReport.setTask(task);
        markReport.setMentor(mentor);
        markReport.setStudent(student);
        markReportDao.update(markReport);

}

    public Set<Student> findStudentsOfCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralService.getIdCourse(titleCourse);
        Course course = courseDao.findOne(idCourse);
        Set<Student> students = course.getStudents();
        if (students.size() != 0) {
            return students;
        } else {
            return null;
        }

    }

}
