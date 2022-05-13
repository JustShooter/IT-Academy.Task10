package by.it.academy.task10;

import by.it.academy.task10.DAO.*;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;


public class AdminServiceTest {

    private final GenericDAO<Student> studentDao = new StudentDao();
    private final GenericDAO<Mentor> mentorDao = new MentorDao();
    private final GenericDAO<Course> courseDao = new CourseDao();
    private final GenericDAO<User> userDao = new UserDAO();

    AdminService adminService = new AdminService();

    @Test
    public void createStudentTest() {
        adminService.createStudent(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME);
        Integer thisStudentId = GeneralService
                .getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME, userDao);

        try {
            Student student = studentDao.findOne(thisStudentId);

            Assertions.assertNotNull(student.getId());
            Assertions.assertEquals(thisStudentId, student.getId());
            Assertions.assertEquals(FIRST_STUDENT_NAME, student.getName());
            Assertions.assertEquals(FIRST_STUDENT_SURNAME, student.getSurname());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createMentorTest() {
        adminService.createMentor(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA);
        Integer thisMentorId = GeneralService
                .getIdUser(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA, userDao);

        try {
            Student mentor = studentDao.findOne(thisMentorId);

            Assertions.assertNotNull(mentor.getId());
            Assertions.assertEquals(thisMentorId, mentor.getId());
            Assertions.assertEquals(MENTOR_NAME_JAVA, mentor.getName());
            Assertions.assertEquals(MENTOR_SURNAME_JAVA, mentor.getSurname());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createCourseTest() {
        adminService.createCourse(TITTLE_JAVA_COURSE);
        Integer thisCourseId = GeneralService.getIdCourse(TITTLE_JAVA_COURSE, courseDao);

        try {
            Course course = courseDao.findOne(thisCourseId);

            Assertions.assertNotNull(course.getId());
            Assertions.assertEquals(thisCourseId, course.getId());
            Assertions.assertEquals(TITTLE_JAVA_COURSE, course.getTitle());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteStudentTest() {
        adminService.createStudent(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME);
        Integer idStudentBefore = GeneralService
                .getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME, userDao);

        try {
            Student student = studentDao.findOne(idStudentBefore);
            adminService.deleteStudent(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME);

            Integer idStudentAfter = GeneralService
                    .getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME, userDao);

            Assertions.assertEquals(idStudentBefore, student.getId());
            Assertions.assertNull(idStudentAfter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteMentorTest() {
        adminService.createMentor(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA);
        Integer idMentorBefore = GeneralService
                .getIdUser(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA, userDao);
        try {
            Mentor mentor = mentorDao.findOne(idMentorBefore);
            adminService.deleteMentor(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA);
            Integer idMentorAfter = GeneralService
                    .getIdUser(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA, userDao);

            Assertions.assertEquals(idMentorBefore, mentor.getId());
            Assertions.assertNull(idMentorAfter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteCourseTest() {
        adminService.createCourse(TITTLE_JAVA_COURSE);
        Integer idCourseBefore = GeneralService
                .getIdCourse(TITTLE_JAVA_COURSE, courseDao);
        try {
            Course course = courseDao.findOne(idCourseBefore);
            adminService.deleteCourse(TITTLE_JAVA_COURSE);
            Integer idCourseAfter = GeneralService
                    .getIdCourse(TITTLE_JAVA_COURSE, courseDao);

            Assertions.assertEquals(idCourseBefore, course.getId());
            Assertions.assertNull(idCourseAfter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllCoursesTest() {

        Course courseJava = createCourseJava();
        Course coursePython = createCoursePython();
        Course courseRuby = createCourseRuby();

        List<Course> allCourses = courseDao.findAll();

        List<Course> getCourseList = adminService.getAllCourses();

        Assertions.assertNotNull(allCourses);
        Assertions.assertNotNull(getCourseList);

        Assertions.assertEquals(getCourseList, allCourses);

        Assertions.assertEquals(getCourseList
                .get(0).getTitle(), allCourses.get(0).getTitle());
        Assertions.assertEquals(getCourseList
                .get(1).getTitle(), allCourses.get(1).getTitle());
        Assertions.assertEquals(getCourseList
                .get(2).getTitle(), allCourses.get(2).getTitle());
    }
}
