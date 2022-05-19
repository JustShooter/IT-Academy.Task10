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
import by.it.academy.task10.services.interfaces.GeneralService;
import by.it.academy.task10.services.interfaces.MentorService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MentorServiceTest {

    private final AdminService adminService = new AdminServiceImpl();
    private final MentorService mentorService = new MentorServiceImpl();
    private final MentorDao mentorDao = new MentorDaoImpl();
    private final TaskDao taskDao = new TaskDaoImpl();
    private final GeneralService generalService = new GeneralServiceImpl();

    @Test
    public void t1_deleteTaskTest() {

        Course course = createCourseJava();
        Mentor mentor = createMentorJava();

        Set<Course> courses = new HashSet<>();
        courses.add(course);

        mentor.setCourses(courses);

        mentorDao.update(mentor);

        try {
            mentorService.createTask(TITTLE_JAVA_COURSE, FIRST_TASK);
            mentorService.deleteTask(FIRST_TASK, TITTLE_JAVA_COURSE);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertNull(generalService.getIdTask(FIRST_TASK, taskDao));
    }

    @Test
    public void t2_findStudentsOfCourseTest() {

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

            Assert.assertNotNull(studentSet);
//            Assert.assertTrue(studentSet.contains(firstStudent));
//            Assert.assertTrue(studentSet.contains(secondStudent));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
