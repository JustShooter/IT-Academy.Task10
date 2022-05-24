package by.it.academy.task10;

import by.it.academy.task10.dao.implementations.CourseDaoImpl;
import by.it.academy.task10.dao.implementations.MentorDaoImpl;
import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.implementations.UserDAOImpl;
import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.interfaces.MentorDao;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.dao.interfaces.UserDao;
import by.it.academy.task10.dto.CourseDto;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.implementations.GeneralServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;
import by.it.academy.task10.services.interfaces.GeneralService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceTest {

    private final CourseDao courseDao = new CourseDaoImpl();
    private final MentorDao mentorDao = new MentorDaoImpl();
    private final StudentDao studentDao = new StudentDaoImpl();
    private final UserDao userDao = new UserDAOImpl();
    private final AdminService adminService = new AdminServiceImpl();
    private final GeneralService generalService = new GeneralServiceImpl();

    @Test
    public void t3_createStudentTest() {
        adminService.createStudent(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME);
        Integer thisStudentId = generalService
                .getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME, userDao);

        try {
            Student student = studentDao.findOne(thisStudentId);

            Assert.assertNotNull(student.getId());
            Assert.assertEquals(thisStudentId, student.getId());
            Assert.assertEquals(FIRST_STUDENT_NAME, student.getName());
            Assert.assertEquals(FIRST_STUDENT_SURNAME, student.getSurname());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t7_createMentorTest() {
        adminService.createMentor(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA);
        Integer thisMentorId = generalService
                .getIdUser(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA, userDao);

        try {
            Student mentor = studentDao.findOne(thisMentorId);

            Assert.assertNotNull(mentor.getId());
            Assert.assertEquals(thisMentorId, mentor.getId());
            Assert.assertEquals(MENTOR_NAME_JAVA, mentor.getName());
            Assert.assertEquals(MENTOR_SURNAME_JAVA, mentor.getSurname());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t5_createCourseTest() {
        adminService.createCourse(TITTLE_JAVA_COURSE);
        Integer thisCourseId = generalService.getIdCourse(TITTLE_JAVA_COURSE, courseDao);

        try {
            Course course = courseDao.findOne(thisCourseId);

            Assert.assertNotNull(course.getId());
            Assert.assertEquals(thisCourseId, course.getId());
            Assert.assertEquals(TITTLE_JAVA_COURSE, course.getTitle());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2_deleteStudentTest() {
        adminService.createStudent(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME);
        Integer idStudentBefore = generalService
                .getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME, userDao);

        try {
            Student student = studentDao.findOne(idStudentBefore);
            adminService.deleteStudent(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME);

            Integer idStudentAfter = generalService
                    .getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME, userDao);

            Assert.assertEquals(idStudentBefore, student.getId());
            Assert.assertNull(idStudentAfter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t1_deleteMentorTest() {
        adminService.createMentor(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA);
        Integer idMentorBefore = generalService
                .getIdUser(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA, userDao);
        try {
            Mentor mentor = mentorDao.findOne(idMentorBefore);
            adminService.deleteMentor(idMentorBefore);
            Integer idMentorAfter = generalService
                    .getIdUser(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA, userDao);

            Assert.assertEquals(idMentorBefore, mentor.getId());
            Assert.assertNull(idMentorAfter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t6_deleteCourseTest() {
        adminService.createCourse(TITTLE_JAVA_COURSE);
        Integer idCourseBefore = generalService
                .getIdCourse(TITTLE_JAVA_COURSE, courseDao);
        try {
            Course course = courseDao.findOne(idCourseBefore);
            adminService.deleteCourse(TITTLE_JAVA_COURSE);
            Integer idCourseAfter = generalService
                    .getIdCourse(TITTLE_JAVA_COURSE, courseDao);

            Assert.assertEquals(idCourseBefore, course.getId());
            Assert.assertNull(idCourseAfter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t4_getAllCoursesTest() {

        createCourseJava();
        createCoursePython();
        createCourseRuby();

        List<Course> allCourses = courseDao.findAll();

        List<CourseDto> getCourseList = adminService.getAllCourses();

        Assert.assertNotNull(allCourses);
        Assert.assertNotNull(getCourseList);

        Assert.assertEquals(getCourseList
                .get(0).getTitle(), allCourses.get(0).getTitle());
        Assert.assertEquals(getCourseList
                .get(1).getTitle(), allCourses.get(1).getTitle());
        Assert.assertEquals(getCourseList
                .get(2).getTitle(), allCourses.get(2).getTitle());
    }
}
