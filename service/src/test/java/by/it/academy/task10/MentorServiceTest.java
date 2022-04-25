package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static by.it.academy.task10.MockUtils.*;
import static by.it.academy.task10.MockUtils.createSecondStudent;

class MentorServiceTest {
    GeneralService generalService;
    private Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);
    private Dao<Student> studentDao = new Dao<>(Student.class);
    private Dao<Task> taskDao = new Dao<>(Task.class);
    private Dao<MarkReport> markReportDao = new Dao<>(MarkReport.class);


    final Mentor mentorBiology = createMentorBiology();
    final Mentor mentorJava = createMentorJava();

    final Course courseBiology = createCourseBiology();
    final Course courseJava = createCourseJava();

    AdminService admin = new AdminService();


    final Task task = createFirstTask();
    final Task task2 = createSecondTask();

    @Test
    void test(){

        final Student firstStudent = createFirstStudent();
        final Student secondStudent = createSecondStudent();

        Student studentDao1 = admin.studentDao.create(firstStudent);
        Student studentDao2 = admin.studentDao.create(secondStudent);


        GeneralService generalService = new GeneralService();
        MentorService mentorService = new MentorService();

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(studentDao1);
        studentSet.add(studentDao2);


        courseBiology.setStudents(studentSet);
        System.out.println(studentSet);

//
//        MentorService mentorService = new MentorService();
//
//
//
//        try {
//            Set<Student> currentSet = mentorService.findStudentsOfCourse(courseBiology.getTitle());
//            Assert.assertNotNull(currentSet);
//            Assert.assertEquals("Не совпадают", currentSet,studentSet);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
}
//