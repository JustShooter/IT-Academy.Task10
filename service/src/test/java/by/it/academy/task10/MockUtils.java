package by.it.academy.task10;

import by.it.academy.task10.dao.implementations.CourseDaoImpl;
import by.it.academy.task10.dao.implementations.MentorDaoImpl;
import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.implementations.TaskDaoImpl;
import by.it.academy.task10.dao.Interfaces.*;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;

import static by.it.academy.task10.MockConstants.*;

public class MockUtils {

    public static CourseDao courseDao = new CourseDaoImpl();
    public static TaskDao taskDao = new TaskDaoImpl();
    public static MentorDao mentorDao = new MentorDaoImpl();
    public static StudentDao studentDao = new StudentDaoImpl();

    public static AdminService adminService = new AdminServiceImpl();


    public static Task createFirstTask() {
        return taskDao.create(Task.builder()
                .title(FIRST_TASK)
                .build());
    }

    public static Task createSecondTask() {
        return taskDao.create(Task.builder()
                .title(SECOND_TASK)
                .build());
    }

    public static Course createCoursePython() {
        return courseDao.create(Course.builder()
                .title(TITTLE_PYTHON_COURSE)
                .build());
    }

    public static Course createCourseRuby() {
        return courseDao.create(Course.builder()
                .title("Ruby course")
                .build());
    }

    public static Course createCourseJava() {
        return courseDao.create(Course.builder()
                .title(TITTLE_JAVA_COURSE)
                .build());
    }

    public static Mentor createMentorJava() {
        return mentorDao.create(Mentor.builder()
                .name(MENTOR_NAME_JAVA)
                .surname(MENTOR_SURNAME_JAVA)
                .build());
    }

    public static Mentor createMentorPython() {
        return mentorDao.create(Mentor.builder()
                .name(MENTOR_NAME_PYTHON)
                .surname(MENTOR_SURNAME_PYTHON)
                .build());
    }

    public static Student createFirstStudent() {
        return studentDao.create(Student.builder()
                .name(FIRST_STUDENT_NAME)
                .surname(FIRST_STUDENT_SURNAME)
                .build());
    }

    public static Student createSecondStudent() {
        return studentDao.create(Student.builder()
                .name(SECOND_STUDENT_NAME)
                .surname(SECOND_STUDENT_SURNAME)
                .build());
    }
}
