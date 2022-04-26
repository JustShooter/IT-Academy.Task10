package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.*;

import static by.it.academy.task10.MockConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {

    AdminService adminService = new AdminService();

    private final Dao<Student> studentDao = new Dao<>(Student.class);
    private final Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    private final Dao<Course> courseDao = new Dao<>(Course.class);

    @Test
    void mentorShouldBeCreatedTest() {
        adminService.createMentor(NAME_USER, SURNAME_USER);
        Integer thisMentorId = GeneralService.getIdUser(NAME_USER, SURNAME_USER);
        boolean mentorIsCreated = false;
        List<Mentor> mentorList = mentorDao.findAll();
        for (Mentor mentor : mentorList) {
            if (mentor.getName().equals(NAME_USER) && mentor.getSurname().equals(SURNAME_USER)
                    && mentor.getId() != null && mentor.getRole().equals("Mentor")
                    && Objects.equals(mentor.getId(), thisMentorId)) {
                mentorIsCreated = true;
                break;
            }
        }
        assertNotNull(GeneralService.getIdUser(NAME_USER, SURNAME_USER));
        assertTrue(mentorIsCreated, "Mentor not created");
    }

    @Test
    void mentorShouldBeRemovedTest() {

        try {
            adminService.createMentor(NAME_USER, SURNAME_USER);
            adminService.deleteMentor(NAME_USER, SURNAME_USER);
            Integer thisMentorId = GeneralService.getIdUser(NAME_USER, SURNAME_USER);
            assertNull(thisMentorId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void studentShouldBeCreatedTest() {
        adminService.createStudent(NAME_USER, SURNAME_USER);
        Integer thisStudentId = GeneralService.getIdUser(NAME_USER, SURNAME_USER);
        boolean studentIsCreated = false;
        List<Student> studentList = studentDao.findAll();
        for (Student student : studentList) {
            if (student.getName().equals(NAME_USER) && student.getSurname().equals(SURNAME_USER)
                    && student.getId() != null && student.getRole().equals("Student")
                    && student.getId().equals(thisStudentId)) {
                studentIsCreated = true;
                break;
            }
        }
        assertNotNull(GeneralService.getIdUser(NAME_USER, SURNAME_USER));
        assertTrue(studentIsCreated, "Student is not created");
    }

    @Test
    void studentShouldBeRemovedTest() {
        try {
            adminService.createStudent(NAME_USER, SURNAME_USER);
            adminService.deleteStudent(NAME_USER, SURNAME_USER);
            Integer thisStudentId = GeneralService.getIdUser(NAME_USER, SURNAME_USER);
            assertNull(thisStudentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void courseShouldBeCreatedTest() {
        adminService.createCourse(COURSE_TITTLE_JAVA);
        Integer thisCourseId = GeneralService.getIdCourse(COURSE_TITTLE_JAVA);
        boolean courseIsCreated = false;
        List<Course> courseList = courseDao.findAll();
        for (Course course : courseList) {
            if (course.getTitle().equals(COURSE_TITTLE_JAVA) && course.getId() != null
                    && course.getId().equals(thisCourseId)) {
                courseIsCreated = true;
                break;
            }
        }
        assertTrue(courseIsCreated, "Course is not created");
    }

    @Test
    void courseShouldBeRemovedTest() {
        adminService.createCourse(COURSE_TITTLE_JAVA);
        try {
            adminService.deleteCourse(COURSE_TITTLE_JAVA);
            Integer thisCourseId = GeneralService.getIdCourse(COURSE_TITTLE_JAVA);
            assertNull(thisCourseId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void showAllCoursesTest() {
        adminService.createCourse(COURSE_TITTLE_JAVA);
        adminService.createCourse(COURSE_TITLE_PYTHON);
        try {
            List<Course> testMethodSet = adminService.getAllCourses();

            List<Course> courseSet = new ArrayList<>();
            courseSet.add(courseDao.findOne(GeneralService.getIdCourse(COURSE_TITTLE_JAVA)));
            courseSet.add(courseDao.findOne(GeneralService.getIdCourse(COURSE_TITLE_PYTHON)));

            assertNotNull(testMethodSet);
            Assert.assertEquals("Not all courses found", testMethodSet, courseSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    //TODO addStudentToCourse
    @Test
    void mentorShouldBeAddedToCourseTest() {
        adminService.createCourse(COURSE_TITTLE_JAVA);
        adminService.createMentor(NAME_USER, SURNAME_USER);
        try {
            Mentor mentor = mentorDao.findOne(GeneralService.getIdUser(NAME_USER, SURNAME_USER));
            Course course = courseDao.findOne(GeneralService.getIdCourse(COURSE_TITTLE_JAVA));
            adminService.addMentorToCourse(NAME_USER, SURNAME_USER, COURSE_TITTLE_JAVA);
            Mentor newMentor = mentorDao.update(mentor);
            Course newCourse = courseDao.update(course);
            System.out.println(course.getMentorCourse());
            System.out.println(newCourse.getMentorCourse());
            System.out.println(mentor.getCourseMentor());
            System.out.println(newMentor.getCourseMentor());
            //Assert.assertEquals("message", mentor, course.getMentorCourse());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
