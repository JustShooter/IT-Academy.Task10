package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.implementations.CourseDaoImpl;
import by.it.academy.task10.dao.implementations.MarkReportDaoImpl;
import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.implementations.UserDAOImpl;
import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.interfaces.MarkReportDao;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.dao.interfaces.UserDao;
import by.it.academy.task10.dto.CourseDto;
import by.it.academy.task10.dto.MarkReportDto;
import by.it.academy.task10.dto.StudentDto;
import by.it.academy.task10.dto.mapper.CourseMapper;
import by.it.academy.task10.dto.mapper.MarkReportMapper;
import by.it.academy.task10.dto.mapper.StudentMapper;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.services.interfaces.GeneralService;
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
    private final GeneralService generalService = new GeneralServiceImpl();
    private final MarkReportDao markReportDao = new MarkReportDaoImpl();

    public void addStudentToCourse(String name, String surname, String title) throws SQLException{
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.addStudentToCourse(name,surname,title);
    }


    public Set<Course> findCoursesOfStudent(Integer idStudent) throws SQLException {
        Student student = studentDao.findOne(idStudent);
        Set<Course> courses = student.getCourses();
        if (!courses.isEmpty()){
            return courses;
        }else {
            return Collections.emptySet();
        }

    }

    public void updateTaskReport(Integer id, String feedback, Integer mark) throws SQLException {
        MarkReport one = markReportDao.findOne(id);
        one.setFeedback(feedback);
        one.setMark(mark);
        markReportDao.update(one);
    }

    public Set<Task> findTasksOfCourse(String titleCourse) throws SQLException {
        Integer idCourse = generalService.getIdCourse(titleCourse,courseDao);
        Course course = courseDao.findOne(idCourse);
        Set<Task> tasks = course.getTasks();
        if (!tasks.isEmpty()){
            return tasks;
        }else {
            return Collections.emptySet();
        }

    }

    public List<MarkReportDto> findReportsOfStudent(String nameStudent, String surnameOfStudent) {
        Integer idStudent = generalService.getIdUser(nameStudent, surnameOfStudent, userDao);
        Student student = null;
        try {
            student = studentDao.findOne(idStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student.getMarkReports().stream()
                .map(MarkReportMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return studentDao.findAll()
                .stream()
                .map(StudentMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public Set<CourseDto> getCoursesOfStudent(Integer studentId) throws SQLException {
        Set<Course> coursesStudent = this.findCoursesOfStudent(studentId);
        if (coursesStudent == null) {
            return Collections.emptySet();
        } else {
            return coursesStudent
                    .stream()
                    .map(CourseMapper::mapFrom)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public Boolean updateStudent(Integer id, String name, String surname) throws SQLException {
        Student student = studentDao.findOne(id);
        student.setName(name);
        student.setSurname(surname);
        Student update = studentDao.update(student);
        if (student.equals(update)) {
            return "STUDENT SUCCESSFULLY UPDATE";
        } else {
            return "UPDATE ERROR";
        }
    }
}
