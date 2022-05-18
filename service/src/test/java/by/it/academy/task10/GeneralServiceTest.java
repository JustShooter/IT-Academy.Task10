package by.it.academy.task10;

import by.it.academy.task10.dao.implementations.CourseDaoImpl;
import by.it.academy.task10.dao.implementations.MentorDaoImpl;
import by.it.academy.task10.dao.implementations.TaskDaoImpl;
import by.it.academy.task10.dao.implementations.UserDAOImpl;
import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.interfaces.MentorDao;
import by.it.academy.task10.dao.interfaces.TaskDao;
import by.it.academy.task10.dao.interfaces.UserDao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.services.implementations.GeneralServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;

class GeneralServiceTest {

    public static CourseDao courseDao = new CourseDaoImpl();
    public static TaskDao taskDao = new TaskDaoImpl();
    public static MentorDao mentorDao = new MentorDaoImpl();
    public static UserDao userDao = new UserDAOImpl();

    @Test
    void getIdUserTest() {

        Student student = createFirstStudent();
        Mentor mentor = createMentorJava();

        Integer currentIdStudent = GeneralServiceImpl.getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME, userDao);
        Integer currentIdMentor = GeneralServiceImpl.getIdUser(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA, userDao);

        Assertions.assertNotNull(currentIdStudent);
        Assertions.assertEquals(currentIdStudent, student.getId());
        Assertions.assertEquals(FIRST_STUDENT_NAME, student.getName());
        Assertions.assertEquals(FIRST_STUDENT_SURNAME, student.getSurname());

        Assertions.assertNotNull(currentIdMentor);
//        Assertions.assertEquals(currentIdMentor, mentor.getId());
        Assertions.assertEquals(MENTOR_NAME_JAVA, mentor.getName());
        Assertions.assertEquals(MENTOR_SURNAME_JAVA, mentor.getSurname());
    }

   /* @Test
    void getIdTaskTest() {

        Task firstTask = createFirstTask();
        Task secondTask = createSecondTask();

        Integer currentIdFirstTask = GeneralServiceImpl.getIdTask(FIRST_TASK, taskDao);
        Integer currentIdSecondTask = GeneralServiceImpl.getIdTask(SECOND_TASK, taskDao);

        Assertions.assertNotNull(currentIdFirstTask);
        Assertions.assertEquals(currentIdFirstTask, firstTask.getId());
        Assertions.assertEquals(FIRST_TASK, firstTask.getTitle());

        Assertions.assertNotNull(currentIdSecondTask);
        Assertions.assertEquals(currentIdSecondTask, secondTask.getId());
        Assertions.assertEquals(SECOND_TASK, secondTask.getTitle());
    }*/

    @Test
    void getIdCourseTest() {

        Course courseJava = createCourseJava();
        Course coursePython = createCoursePython();

        Integer currentIdJavaCourse = GeneralServiceImpl.getIdCourse(TITTLE_JAVA_COURSE, courseDao);
        Integer currentIdJavaPython = GeneralServiceImpl.getIdCourse(TITTLE_PYTHON_COURSE, courseDao);

        Assertions.assertNotNull(currentIdJavaCourse);
//        Assertions.assertEquals(currentIdJavaCourse, courseJava.getId());
        Assertions.assertEquals(TITTLE_JAVA_COURSE, courseJava.getTitle());

        Assertions.assertNotNull(currentIdJavaPython);
//        Assertions.assertEquals(currentIdJavaPython, coursePython.getId());
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

        Integer idMentorOfPythonCourse = GeneralServiceImpl
                .getIdMentorOfCourse(TITTLE_PYTHON_COURSE, courseDao);

        Integer idMentorOfJavaCourse = GeneralServiceImpl
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

        Integer currentTaskId = GeneralServiceImpl
                .getIdTask(FIRST_TASK, taskDao);

        Assertions.assertNotNull(currentTaskId);
        Assertions.assertEquals(currentTaskId, firstTask.getId());
        Assertions.assertEquals(courseJava, firstTask.getTaskCourse());
        Assertions.assertEquals(taskList, firstTask.getTaskCourse().getTasks());
    }

}