package by.it.academy.task10;

import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;

import static by.it.academy.task10.MockConstants.*;

public class MockUtils {

    public static Task createFirstTask() {
        return Task.builder()
                .title(FIRST_TASK)
                .build();
    }
    public static Task createSecondTask() {
        return Task.builder()
                .title(SECOND_TASK)
                .build();
    }

    public static Course createCourseBiology() {
        return Course.builder()
                .title(COURSE_TITLE_BIOLOGY)
                .build();
    }
    public static Course createCourseJava() {
        return Course.builder()
                .title(COURSE_TITLE_JAVA)
                .build();
    }
    public static Mentor createMentorBiology() {
        return Mentor.builder()
                .name(MENTOR_NAME_BIOLOGY)
                .surname(MENTOR_SURNAME_BIOLOGY)
                .role(MENTOR_ROLE_BIOLOGY)
                .build();
    }
    public static Mentor createMentorJava() {
        return Mentor.builder()
                .name(MENTOR_NAME_JAVA)
                .surname(MENTOR_SURNAME_JAVA)
                .role(MENTOR_ROLE_JAVA)
                .build();
    }

    public static Student createFirstStudent() {
        return Student.builder()
                .name(FIRST_STUDENT_NAME)
                .surname(FIRST_STUDENT_SURNAME)
                .role(FIRST_STUDENT_ROLE)
                .build();
    }
    public static Student createSecondStudent() {
        return Student.builder()
                .name(SECOND_STUDENT_NAME)
                .surname(SECOND_STUDENT_SURNAME)
                .role(SECOND_STUDENT_ROLE)
                .build();
    }
}
