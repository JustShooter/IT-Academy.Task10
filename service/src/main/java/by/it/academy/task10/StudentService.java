package by.it.academy.task10;

import by.it.academy.task10.dao.*;
import by.it.academy.task10.dao.Interfaces.CourseDaoInt;
import by.it.academy.task10.dao.Interfaces.GenericDAO;
import by.it.academy.task10.dao.Interfaces.StudentDaoInt;
import by.it.academy.task10.dao.Interfaces.UserDaoInt;
import by.it.academy.task10.entity.*;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Set;

public class StudentService {
    private final StudentDaoInt studentDao = new StudentDao();
    private final CourseDaoInt courseDao = new CourseDao();
    private final UserDaoInt userDao = new UserDAO();

    public void addStudentToCourse(String name, String surname, String title) throws SQLException{
        AdminService adminService = new AdminService();
        adminService.addStudentToCourse(name,surname,title);
    }



    public Set<Course> findCoursesOfStudent(String nameStudent, String surnameStudent) throws SQLException {
        Integer idStudent = GeneralService.getIdUser(nameStudent, surnameStudent,userDao);
        Student student = studentDao.findOne(idStudent);
        Set<Course> courses = student.getCourses();
        if (!courses.isEmpty()){
            return courses;
        }else {
            return Collections.emptySet();
        }

    }

    public Set<Task> findTasksOfCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralService.getIdCourse(titleCourse,courseDao);
        Course course = courseDao.findOne(idCourse);
        Set<Task> tasks = course.getTasks();
        if (!tasks.isEmpty()){
            return tasks;
        }else {
            return Collections.emptySet();
        }

    }

    public Set<MarkReport> findReportsOfStudent(String nameStudent, String surnameOfStudent) throws SQLException {
        Integer idStudent = GeneralService.getIdUser(nameStudent, surnameOfStudent,userDao);
        Student student = studentDao.findOne(idStudent);
        Set<MarkReport> reports = student.getMarkReports();
        if (!reports.isEmpty()){
            return reports;
        }else {
            return Collections.emptySet();
        }
    }

}
