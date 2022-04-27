package by.it.academy.task10;

import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class AdminServiceTest {
//    AdminService as = new AdminService();
//    GeneralService gs = new GeneralService();
//    private GenericDAO<Student> studentDao = new GenericDAO<>(Student.class);
//    GenericDAO<Mentor> mentorDao = new GenericDAO<>(Mentor.class);
//    GenericDAO<Course> courseDao = new GenericDAO<>(Course.class);
//
//    @Before
//    public void init(){
//        as.createStudent("Сергей", "Сварцевич");
//        as.createStudent("John", "Weak");
//        as.addCourse("Java");
//        as.createMentor("Жанна", "Колесень");
//        as.createMentor("Инга", "Чешун");
//        as.addCourse("C++");
//    }
//
//    @Test
//    public void createStudentSuccessfully() {
//        assertTrue(as.createStudent("Степан", "Смоленский"));
//    }
//
//    @Test
//    public void createStudentFailure() {
//        assertFalse(as.createStudent("Сергей", "Сварцевич"));
//    }
//
//    @Test
//    public void deleteStudent() throws SQLException {
//        as.deleteStudent("John", "Weak");
//        assertNull(gs.getIdUser("John", "Weak"));
//    }
//
//    @Test
//    public void addStudentToCourse() throws SQLException {
//        as.addStudentToCourse("Степан", "Смоленский", "Java");
//        Set<Course> courses = studentDao.findOne
//                (gs.getIdUser("Степан", "Смоленский")).getCourses();
//        assertNotNull(courses);
//    }
//
//    @Test
//    public void createMentorSuccessfully() {
//        assertTrue(as.createMentor("Елизавета", "Велимович"));
//    }
//
//    @Test
//    public void createMentorFailure() {
//        assertFalse(as.createMentor("Жанна", "Колесень"));
//    }
//
//    @Test
//    public void deleteMentor() throws SQLException {
//        as.deleteMentor("Инга", "Чешун");
//        assertNull(gs.getIdUser("Инга", "Чешун"));
//    }
//
//    @Test
//    public void addMentorToCourse() throws SQLException {
//        as.addMentorToCourse("Жанна", "Колесень", "Java");
//       /* Course java = courseDao.findOne(gs.getIdCourse("Java"));*/
//        Course course = mentorDao.findOne
//                (gs.getIdUser("Жанна", "Колесень")).getCourseMentor();
//        /*assertEquals(course, java);*/
//        assertNotNull(course);
//    }
//
//    /*@Test
//    public void getAllCourses() throws SQLException {
//        List<Course> list = as.getAllCourses();
//        Course course = list.get(gs.getIdCourse("Java") - 1);
//        Course one = courseDao.findOne(gs.getIdCourse("Java"));
//        assertEquals(course, one);
//    }*/
//
//    @Test
//    public void addCourseFailure() {
//        assertFalse(as.addCourse("C++"));
//    }
}