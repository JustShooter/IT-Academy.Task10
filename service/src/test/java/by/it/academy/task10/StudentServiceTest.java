package by.it.academy.task10;

import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Set;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;

class StudentServiceTest {

    @Test
    void addStudentToCourseTest() {

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
                    .findCoursesOfStudent(student.getName(), student.getSurname());

            Set<Course> secondStudentCourses = studentService
                    .findCoursesOfStudent(student2.getName(), student2.getSurname());

            Assertions.assertTrue(firstStudentCourses.contains(courseJava));
            Assertions.assertTrue(firstStudentCourses.contains(coursePython));

            Assertions.assertFalse(secondStudentCourses.contains(coursePython));
            Assertions.assertTrue(secondStudentCourses.contains(courseJava));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findCoursesOfStudentTest() {

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

            studentService.findCoursesOfStudent(FIRST_STUDENT_NAME,
                    FIRST_STUDENT_SURNAME);

            Set<Course> firstStudentCourses = studentService
                    .findCoursesOfStudent(student.getName(), student.getSurname());

            Set<Course> secondStudentCourses = studentService
                    .findCoursesOfStudent(student2.getName(), student2.getSurname());


            Assertions.assertTrue(firstStudentCourses.contains(courseJava));
            Assertions.assertTrue(firstStudentCourses.contains(coursePython));

            Assertions.assertFalse(secondStudentCourses.contains(coursePython));
            Assertions.assertTrue(secondStudentCourses.contains(courseJava));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}