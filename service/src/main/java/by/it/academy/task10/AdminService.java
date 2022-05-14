package by.it.academy.task10;

import by.it.academy.task10.dao.GenericDAO;
import by.it.academy.task10.dao.impl.CourseDaoImpl;
import by.it.academy.task10.dao.impl.MentorDaoImpl;
import by.it.academy.task10.dao.impl.StudentDaoImpl;
import by.it.academy.task10.dao.impl.UserDAO;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.User;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdminService {
    private final GenericDAO<Student> studentDao = new StudentDaoImpl();
    private final GenericDAO<Mentor> mentorDao = new MentorDaoImpl();
    private final GenericDAO<Course> courseDao = new CourseDaoImpl();
    private final GenericDAO<User> userDao = new UserDAO();

    public void createStudent(String name, String surname) {
        Integer idUser = GeneralService.getIdUser(name, surname, userDao);
        if (idUser == null) {
            studentDao.create(Student.builder()
                    .name(name)
                    .surname(surname)
                    .build());
        } else {
            System.out.println("Student already exist");
        }
    }

    public void deleteStudent(String name, String surname) throws SQLException {
        Integer idUser = GeneralService.getIdUser(name, surname,userDao);
        studentDao.deleteById(idUser);
    }

    public void addStudentToCourse(String name, String surname, String title) throws SQLException {
        Integer idStudent = GeneralService.getIdUser(name, surname,userDao);
        Student student = studentDao.findOne(idStudent);
        Integer idCourse = GeneralService.getIdCourse(title,courseDao);
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
        Integer idUser = GeneralService.getIdUser(name, surname,userDao);
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
        Integer idMentor = GeneralService.getIdUser(name, surname,userDao);
        mentorDao.deleteById(idMentor);
    }

    public void createCourse(String titleCourse) {
        Integer idCourse = GeneralService.getIdCourse(titleCourse,courseDao);
        if (idCourse == null) {
            Course course = courseDao.create(Course.builder()
                    .title(titleCourse)
                    .build());
        } else {
            System.out.println("Course already exist");
        }
    }

    public void deleteCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralService.getIdCourse(titleCourse,courseDao);
        courseDao.deleteById(idCourse);
    }

    public void addMentorToCourse(String name, String surname, String title) throws SQLException {
        Integer idMentor = GeneralService.getIdUser(name, surname,userDao);
        Mentor mentor = mentorDao.findOne(idMentor);
        Integer idCourse = GeneralService.getIdCourse(title,courseDao);
        Course course = courseDao.findOne(idCourse);
        if (course.getMentor() == null) {
            Set<Course> courses = new HashSet<>();
            if (mentor.getCourses() == null){
                courses.add(course);
            }else {
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
