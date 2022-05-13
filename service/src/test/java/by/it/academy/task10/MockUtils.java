package by.it.academy.task10;

import by.it.academy.task10.DAO.*;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;

import static by.it.academy.task10.MockConstants.*;

public class MockUtils {

    public static GenericDAO<Course> courseDao = new CourseDao();
    public static GenericDAO<Task> taskDao = new TaskDao();
    public static GenericDAO<Mentor> mentorDao = new MentorDao();
    public static GenericDAO<Student> studentDao = new StudentDao();

    public static AdminService adminService = new AdminService();


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
                .role(MENTOR_ROLE_JAVA)
                .build());
    }

    public static Mentor createMentorPython() {
        return mentorDao.create(Mentor.builder()
                .name(MENTOR_NAME_PYTHON)
                .surname(MENTOR_SURNAME_PYTHON)
                .role("Mentor")
                .build());
    }

    public static Student createFirstStudent() {
        return studentDao.create(Student.builder()
                .name(FIRST_STUDENT_NAME)
                .surname(FIRST_STUDENT_SURNAME)
                .role(FIRST_STUDENT_ROLE)
                .build());
    }

    public static Student createSecondStudent() {
        return studentDao.create(Student.builder()
                .name(SECOND_STUDENT_NAME)
                .surname(SECOND_STUDENT_SURNAME)
                .role(SECOND_STUDENT_ROLE)
                .build());

    }
}
