package by.it.academy.task10;

import by.it.academy.task10.dao.implementations.MentorDaoImpl;
import by.it.academy.task10.dao.implementations.TaskDaoImpl;
import by.it.academy.task10.dao.interfaces.MentorDao;
import by.it.academy.task10.dao.interfaces.TaskDao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.implementations.GeneralServiceImpl;
import by.it.academy.task10.services.implementations.MentorServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;
import by.it.academy.task10.services.interfaces.MentorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;


class MentorServiceTest {

    AdminService adminService = new AdminServiceImpl();
    MentorService mentorService = new MentorServiceImpl();
    MentorDao mentorDao = new MentorDaoImpl();
    TaskDao taskDao = new TaskDaoImpl();

    @Test
    void deleteTaskTest() {

        Course course = createCourseJava();
        Mentor mentor = createMentorJava();

        Set<Course> courses = new HashSet<>();
        courses.add(course);

        mentor.setCourses(courses);

        mentorDao.update(mentor);

        try {
            mentorService.createTask(TITTLE_JAVA_COURSE, FIRST_TASK);
            mentorService.deleteTask(FIRST_TASK, TITTLE_JAVA_COURSE);

            Assertions.assertNull(GeneralServiceImpl.getIdTask(FIRST_TASK, taskDao));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /* @Test
    void findStudentsOfCourseTest() {

        Course course = createCourseJava();
        Student firstStudent = createFirstStudent();
        Student secondStudent = createSecondStudent();

        try {
            adminService.addStudentToCourse(FIRST_STUDENT_NAME,
                    FIRST_STUDENT_SURNAME,
                    TITTLE_JAVA_COURSE);

            adminService.addStudentToCourse(SECOND_STUDENT_NAME,
                    SECOND_STUDENT_SURNAME,
                    TITTLE_JAVA_COURSE);

            Set<Student> studentSet = mentorService.findStudentsOfCourse(course.getTitle());

            Assertions.assertNotNull(studentSet);
            Assertions.assertTrue(studentSet.contains(firstStudent));
            Assertions.assertTrue(studentSet.contains(secondStudent));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
