package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.implementations.CourseDaoImpl;
import by.it.academy.task10.dao.implementations.MentorDaoImpl;
import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.implementations.UserDAOImpl;
import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.interfaces.MentorDao;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.dao.interfaces.UserDao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.services.interfaces.AdminService;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdminServiceImpl implements AdminService {
    private static StudentDao studentDao = new StudentDaoImpl();
    private static MentorDao mentorDao = new MentorDaoImpl();
    private static CourseDao courseDao = new CourseDaoImpl();
    private static UserDao userDao = new UserDAOImpl();

    public void createStudent(String name, String surname) {
        Integer idUser = GeneralServiceImpl.getIdUser(name, surname, userDao);
        if (idUser == null) {
            studentDao.create(Student.builder()
                    .name(name)
                    .surname(surname)
                    .build());
        }
    }

    public void deleteStudent(String name, String surname) throws SQLException {
        Integer idUser = GeneralServiceImpl.getIdUser(name, surname, userDao);
        studentDao.deleteById(idUser);
    }

    public void addStudentToCourse(String name, String surname, String title) throws SQLException {
        Integer idStudent = GeneralServiceImpl.getIdUser(name, surname, userDao);
        Student student = studentDao.findOne(idStudent);
        Integer idCourse = GeneralServiceImpl.getIdCourse(title, courseDao);
        Course course = courseDao.findOne(idCourse);
        Set<Course> courseSet = student.getCourses();
        if (courseSet != null) {
            student.getCourses().add(course);
        } else {
            Set<Course> set = new HashSet<>();
            set.add(course);
            student.setCourses(set);
        }
        studentDao.update(student);
    }

    public void createMentor(String name, String surname) {
        Integer idUser = GeneralServiceImpl.getIdUser(name, surname, userDao);
        if (idUser == null) {
            Mentor mentor = mentorDao.create(Mentor.builder()
                    .name(name)
                    .surname(surname)
                    .build());
        } else {
            System.out.println("Mentor already exist");
        }
    }

    public void deleteMentor(String name, String surname) throws SQLException {
        Integer idMentor = GeneralServiceImpl.getIdUser(name, surname, userDao);
        mentorDao.deleteById(idMentor);
    }

    public void createCourse(String titleCourse) {
        Integer idCourse = GeneralServiceImpl.getIdCourse(titleCourse, courseDao);
        if (idCourse == null) {
            Course course = courseDao.create(Course.builder()
                    .title(titleCourse)
                    .build());
        } else {
            System.out.println("Course already exist");
        }
    }

    public void deleteCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralServiceImpl.getIdCourse(titleCourse, courseDao);
        courseDao.deleteById(idCourse);
    }

    public void addMentorToCourse(String name, String surname, String title) throws SQLException {
        Integer idMentor = GeneralServiceImpl.getIdUser(name, surname, userDao);
        Mentor mentor = mentorDao.findOne(idMentor);
        Integer idCourse = GeneralServiceImpl.getIdCourse(title, courseDao);
        Course course = courseDao.findOne(idCourse);
        if (course.getMentor() == null) {
            Set<Course> courses = new HashSet<>();
            if (mentor.getCourses() == null) {
                courses.add(course);
            } else {
                mentor.getCourses().add(course);
            }
            mentor.setCourses(courses);
            course.setMentor(mentor);
            mentorDao.update(mentor);
            courseDao.update(course);

        } else {
            System.out.println("For this course the mentor has been already assigned");
        }
    }

    public List<Course> getAllCourses() {
        List<Course> all = courseDao.findAll();
        if (all.size() != 0) {
            return all;
        } else {
            return null;
        }
    }
}
