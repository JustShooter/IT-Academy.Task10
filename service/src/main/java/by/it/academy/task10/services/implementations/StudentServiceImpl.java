package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.implementations.CourseDaoImpl;
import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.implementations.UserDAOImpl;
import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.dao.interfaces.UserDao;
import by.it.academy.task10.dto.StudentDto;
import by.it.academy.task10.dto.mapper.StudentMapper;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.services.interfaces.StudentService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = new StudentDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();
    private final UserDao userDao = new UserDAOImpl();

    public void addStudentToCourse(String name, String surname, String title) throws SQLException {
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.addStudentToCourse(name, surname, title);
    }


    public Set<Course> findCoursesOfStudent(String nameStudent, String surnameStudent) throws SQLException {
        Integer idStudent = GeneralServiceImpl.getIdUser(nameStudent, surnameStudent, userDao);
        Student student = studentDao.findOne(idStudent);
        Set<Course> courses = student.getCourses();
        if (!courses.isEmpty()) {
            return courses;
        } else {
            return Collections.emptySet();
        }

    }

    public Set<Task> findTasksOfCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralServiceImpl.getIdCourse(titleCourse, courseDao);
        Course course = courseDao.findOne(idCourse);
        Set<Task> tasks = course.getTasks();
        if (!tasks.isEmpty()) {
            return tasks;
        } else {
            return Collections.emptySet();
        }

    }

    public Set<MarkReport> findReportsOfStudent(String nameStudent, String surnameOfStudent) throws SQLException {
        Integer idStudent = GeneralServiceImpl.getIdUser(nameStudent, surnameOfStudent, userDao);
        Student student = studentDao.findOne(idStudent);
        Set<MarkReport> reports = student.getMarkReports();
        if (!reports.isEmpty()) {
            return reports;
        } else {
            return Collections.emptySet();
        }
    }

    public List<StudentDto> findAllStudents() {
        return studentDao.findAll()
                .stream()
                .map(StudentMapper::mapFrom)
                .collect(Collectors.toList());
    }

}
