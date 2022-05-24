package by.it.academy.task10;

import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;
import by.it.academy.task10.services.interfaces.StudentService;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {

    @Test
    public void t2_addStudentToCourseTest() {

        StudentService studentService = new StudentServiceImpl();

        Student student = createFirstStudent();
        Student student2 = createSecondStudent();

        Course courseJava = createCourseJava();
        Course coursePython = createCoursePython();

        try {
            studentService.addStudentToCourse(FIRST_STUDENT_NAME,
                    FIRST_STUDENT_SURNAME,
                    TITTLE_JAVA_COURSE);

            studentService.addStudentToCourse(FIRST_STUDENT_NAME,
                    FIRST_STUDENT_SURNAME,
                    TITTLE_PYTHON_COURSE);

            studentService.addStudentToCourse(SECOND_STUDENT_NAME,
                    SECOND_STUDENT_SURNAME,
                    TITTLE_JAVA_COURSE);

            Set<Course> firstStudentCourses = studentService
                    .findCoursesOfStudent(student.getId());

            Set<Course> secondStudentCourses = studentService
                    .findCoursesOfStudent(student2.getId());

            Assert.assertTrue(firstStudentCourses.contains(courseJava));
            Assert.assertTrue(firstStudentCourses.contains(coursePython));

            Assert.assertFalse(secondStudentCourses.contains(coursePython));
            Assert.assertTrue(secondStudentCourses.contains(courseJava));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void t1_findCoursesOfStudentTest() throws SQLException {
//
//        StudentService studentService = new StudentServiceImpl();
//
//        Student student = createFirstStudent();
//        Student student2 = createSecondStudent();
//
//        Course courseJava = createCourseJava();
//        Course coursePython = createCoursePython();
//
//        Set<Course> firstStudentCourses = null;
//        Set<Course> secondStudentCourses = null;
//        try {
//            studentService.addStudentToCourse(FIRST_STUDENT_NAME,
//                    FIRST_STUDENT_SURNAME,
//                    TITTLE_JAVA_COURSE);
//
//            studentService.addStudentToCourse(FIRST_STUDENT_NAME,
//                    FIRST_STUDENT_SURNAME,
//                    TITTLE_PYTHON_COURSE);
//
//            studentService.addStudentToCourse(SECOND_STUDENT_NAME,
//                    SECOND_STUDENT_SURNAME,
//                    TITTLE_JAVA_COURSE);
//
//            studentService.findCoursesOfStudent(FIRST_STUDENT_NAME,
//                    FIRST_STUDENT_SURNAME);
//
//            firstStudentCourses = studentService
//                    .findCoursesOfStudent(student.getName(), student.getSurname());
//
//            secondStudentCourses = studentService
//                    .findCoursesOfStudent(student2.getName(), student2.getSurname());
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Assert.assertTrue(firstStudentCourses.contains(courseJava));
//        Assert.assertTrue(firstStudentCourses.contains(coursePython));
//
//        Assert.assertFalse(secondStudentCourses.contains(coursePython));
//        Assert.assertTrue(secondStudentCourses.contains(courseJava));
//        adminService.deleteCourse(courseJava.getTitle());
//        adminService.deleteCourse(coursePython.getTitle());
//        adminService.deleteStudent(student.getName(), student.getSurname());
//        adminService.deleteStudent(student2.getName(), student2.getSurname());
//    }
}