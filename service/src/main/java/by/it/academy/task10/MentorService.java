package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.*;

import java.sql.SQLException;
import java.util.Set;

public class MentorService{

    GeneralService generalService = new GeneralService();
    private Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);
    private Dao<Student> studentDao = new Dao<>(Student.class);
    private Dao<Task> taskDao = new Dao<>(Task.class);
    private Dao<MarkReport> markReportDao = new Dao<>(MarkReport.class);


    public void createTask(String titleCourse, String titleTask) throws SQLException {
        Integer idCourse = generalService.getIdCourse(titleCourse);
        Course course = courseDao.findOne(idCourse);
        Task task = taskDao.create(Task.builder()
                .title(titleTask)
                .taskCourse(course)
                .build());
        Set<Task> tasks = course.getTasks();
        if (tasks != null) {
            tasks.add(task);
        } else {
            tasks = Set.of(task);
        }
        course.setTasks(tasks);
        courseDao.update(course);
    }

    public void deleteTask(String titleTask, String titleCourse) throws SQLException {
        Integer idTaskFromCourse = generalService.getIdTaskFromCourse(titleTask, titleCourse);
        Task one = taskDao.findOne(idTaskFromCourse);
        taskDao.delete(one);

    }

    public void rateAndFeedbackStudentTask(String nameStudent, String surnameStudent,
                                           String nameMentor, String surnameMentor, String titleTask,
                                           Integer mark, String feedback) throws SQLException {

        Integer idStudent = generalService.getIdUser(nameStudent, surnameStudent);
        Integer idMentor = generalService.getIdUser(nameMentor, surnameMentor);
        Integer idTask = generalService.getIdTask(titleTask);
        Task task = taskDao.findOne(idTask);
        Mentor mentor = mentorDao.findOne(idMentor);
        Student student = studentDao.findOne(idStudent);
        MarkReport markReport = markReportDao.create(MarkReport.builder()
                .feedback(feedback)
                .mark(mark)
                .tasks(Set.of(task))
                .mentors(Set.of(mentor))
                .students(Set.of(student))
                .build());

        markReportDao.update(markReport);

    }

    public Set<Student> findStudentsOfCourse(String titleCourse) throws SQLException {
        Integer idCourse = generalService.getIdCourse(titleCourse);
        Course course = courseDao.findOne(idCourse);
        Set<Student> students = course.getStudents();
        if (students.size() != 0){
            return students;
        }else {
            return null;
        }

    }

}
