package by.it.academy.task10;

import by.it.academy.task10.dao.impl.CourseDaoImpl;
import by.it.academy.task10.dao.impl.StudentDaoImpl;
import by.it.academy.task10.dao.impl.UserDAO;
import by.it.academy.task10.dao.GenericDAO;
import by.it.academy.task10.entity.*;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Set;

public class StudentService {
    private final GenericDAO<Student> studentDao = new StudentDaoImpl();
    private final GenericDAO<Course> courseDao = new CourseDaoImpl();
    private final GenericDAO<User> userDao = new UserDAO();

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
