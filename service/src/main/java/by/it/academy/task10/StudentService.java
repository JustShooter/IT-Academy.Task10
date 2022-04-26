package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class StudentService {
    private final Dao<Student> studentDao = new Dao<>(Student.class);
    private final Dao<Course> courseDao = new Dao<>(Course.class);

    public Set<Course> findCoursesOfStudent(String nameStudent, String surnameStudent) throws SQLException {
        Integer idStudent = GeneralService.getIdUser(nameStudent, surnameStudent);
        Student student = studentDao.findOne(idStudent);
        Set<Course> courses = student.getCourses();
        if (!courses.isEmpty()){
            return courses;
        }else {
            return Collections.emptySet();
        }

    }

    public Set<Task> findTasksOfCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralService.getIdCourse(titleCourse);
        Course course = courseDao.findOne(idCourse);
//        Set<Task> tasks = course.getTasks();
        Set<Task> tasks = course.getTasks();
        if (!tasks.isEmpty()){
            return tasks;
        }else {
            return Collections.emptySet();
        }

    }

    public Set<MarkReport> findReportsOfStudent(String nameStudent, String surnameOfStudent) throws SQLException {
        Integer idStudent = GeneralService.getIdUser(nameStudent, surnameOfStudent);
        Student student = studentDao.findOne(idStudent);
        Set<MarkReport> reports = student.getMarkReports();
        if (!reports.isEmpty()){
            return reports;
        }else {
            return Collections.emptySet();
        }
    }

}