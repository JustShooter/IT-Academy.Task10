package by.it.academy.task10;

import by.it.academy.task10.dao.*;
import by.it.academy.task10.dao.Interfaces.*;
import by.it.academy.task10.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;

class GeneralServiceTest {

    public static CourseDaoInt courseDao = new CourseDao();
    public static TaskDaoInt taskDao = new TaskDao();
    public static MentorDaoInt mentorDao = new MentorDao();
    public static UserDaoInt userDao = new UserDAO();

    @Test
    void getIdUserTest() {

        Student student = createFirstStudent();
        Mentor mentor = createMentorJava();

        Integer currentIdStudent = GeneralService.getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME, userDao);
        Integer currentIdMentor = GeneralService.getIdUser(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA, userDao);

        Assertions.assertNotNull(currentIdStudent);
        Assertions.assertEquals(currentIdStudent, student.getId());
        Assertions.assertEquals(FIRST_STUDENT_NAME, student.getName());
        Assertions.assertEquals(FIRST_STUDENT_SURNAME, student.getSurname());

        Assertions.assertNotNull(currentIdMentor);
        Assertions.assertEquals(currentIdMentor, mentor.getId());
        Assertions.assertEquals(MENTOR_NAME_JAVA, mentor.getName());
        Assertions.assertEquals(MENTOR_SURNAME_JAVA, mentor.getSurname());
    }

    @Test
    void getIdTaskTest() {

        Task firstTask = createFirstTask();
        Task secondTask = createSecondTask();

        Integer currentIdFirstTask = GeneralService.getIdTask(FIRST_TASK, taskDao);
        Integer currentIdSecondTask = GeneralService.getIdTask(SECOND_TASK, taskDao);

        Assertions.assertNotNull(currentIdFirstTask);
        Assertions.assertEquals(currentIdFirstTask, firstTask.getId());
        Assertions.assertEquals(FIRST_TASK, firstTask.getTitle());

        Assertions.assertNotNull(currentIdSecondTask);
        Assertions.assertEquals(currentIdSecondTask, secondTask.getId());
        Assertions.assertEquals(SECOND_TASK, secondTask.getTitle());
    }

    @Test
    void getIdCourseTest() {

        Course courseJava = createCourseJava();
        Course coursePython = createCoursePython();

        Integer currentIdJavaCourse = GeneralService.getIdCourse(TITTLE_JAVA_COURSE, courseDao);
        Integer currentIdJavaPython = GeneralService.getIdCourse(TITTLE_PYTHON_COURSE, courseDao);

        Assertions.assertNotNull(currentIdJavaCourse);
        Assertions.assertEquals(currentIdJavaCourse, courseJava.getId());
        Assertions.assertEquals(TITTLE_JAVA_COURSE, courseJava.getTitle());

        Assertions.assertNotNull(currentIdJavaPython);
        Assertions.assertEquals(currentIdJavaPython, coursePython.getId());
        Assertions.assertEquals(TITTLE_PYTHON_COURSE, coursePython.getTitle());
    }

    @Test
    void getIdMentorOfCourseTest() {

        Mentor mentorJava = createMentorJava();
        Mentor mentorPython = createMentorPython();
        Course courseJava = createCourseJava();
        Course coursePython = createCoursePython();

        courseJava.setMentor(mentorJava);
        coursePython.setMentor(mentorPython);

        Set<Course> courseSetForJavaMentor = new HashSet<>();
        courseSetForJavaMentor.add(courseJava);
        courseSetForJavaMentor.add(coursePython);

        Set<Course> courseSetForPythonMentor = new HashSet<>();
        courseSetForJavaMentor.add(coursePython);
        courseSetForJavaMentor.add(courseJava);

        mentorJava.setCourses(courseSetForJavaMentor);
        mentorPython.setCourses(courseSetForPythonMentor);

        courseDao.update(courseJava);
        courseDao.update(coursePython);

        mentorDao.update(mentorJava);
        mentorDao.update(mentorPython);

        Integer idMentorOfPythonCourse = GeneralService
                .getIdMentorOfCourse(TITTLE_PYTHON_COURSE, courseDao);

        Integer idMentorOfJavaCourse = GeneralService
                .getIdMentorOfCourse(TITTLE_JAVA_COURSE, courseDao);

        Assertions.assertNotNull(idMentorOfPythonCourse);
        Assertions.assertEquals(idMentorOfPythonCourse, mentorPython.getId());
        Assertions.assertEquals(courseSetForPythonMentor, mentorPython.getCourses());

        Assertions.assertNotNull(idMentorOfJavaCourse);
        Assertions.assertEquals(idMentorOfJavaCourse, mentorJava.getId());
        Assertions.assertEquals(courseSetForJavaMentor, mentorJava.getCourses());
    }


    @Test
    void getIdTaskFromCourseTest() {

        Course courseJava = createCourseJava();
        Task firstTask = createFirstTask();
        Task secondTask = createSecondTask();

        Set<Task> taskList = new HashSet<>();
        taskList.add(firstTask);
        taskList.add(secondTask);

        firstTask.setTaskCourse(courseJava);
        secondTask.setTaskCourse(courseJava);
        courseJava.setTasks(taskList);

        taskDao.update(firstTask);
        taskDao.update(secondTask);

        Integer currentTaskId = GeneralService
                .getIdTask(FIRST_TASK, taskDao);

        Assertions.assertNotNull(currentTaskId);
        Assertions.assertEquals(currentTaskId, firstTask.getId());
        Assertions.assertEquals(courseJava, firstTask.getTaskCourse());
        Assertions.assertEquals(taskList, firstTask.getTaskCourse().getTasks());
    }

}