package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static by.it.academy.task10.MockUtils.*;

class GeneralServiceTest {

    private Dao<User> userDao = new Dao<>(User.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);
    private Dao<Task> taskDao = new Dao<>(Task.class);

    AdminService admin = new AdminService();
    GeneralService generalService = new GeneralService();
    
    final Mentor mentorBiology = createMentorBiology();
    final Mentor mentorJava = createMentorJava();

    final Course courseBiology = createCourseBiology();
    final Course courseJava = createCourseJava();

    final Task task = createFirstTask();
    final Task task2 = createSecondTask();

    final Student firstStudent = createFirstStudent();
    final Student secondStudent = createSecondStudent();

    @Test
    void test(){

//        courseBiology.setMentorCourse(mentorBiology);
//        courseJava.setMentorCourse(mentorJava);


    }

    @Test
    void getIdFromUser(){

        Student studentDao = admin.studentDao.create(firstStudent);

        Integer currentId = generalService.getIdUser(firstStudent.getName(), firstStudent.getSurname());

        Assertions.assertNotNull(studentDao);
        Assertions.assertNotNull(studentDao.getId());
        Assertions.assertEquals(currentId, studentDao.getId(), "Id not equals");

    }

    @Test
    void getIdFromCourse(){

        Course courseDao = admin.courseDao.create(courseJava);

        Integer currentId = generalService.getIdCourse(courseJava.getTitle());

        Assertions.assertNotNull(courseDao);
        Assertions.assertNotNull(courseDao.getId());
        Assertions.assertEquals(currentId, courseDao.getId(), "Id not equals");
    }

    @Test
    void getTaskIdFromCourse(){
        Set<Task> taskSet = new HashSet<>();
        Set<Course> courseSet = new HashSet<>();
        courseSet.add(courseBiology);
        courseSet.add(courseJava);
        taskSet.add(task);
        taskSet.add(task2);
        courseJava.setTasks(taskSet);
        // TODO
        Integer currentId = generalService.getIdTaskFromCourse(task.getTitle(),courseJava.getTitle());
        System.out.println(currentId);
    }

}