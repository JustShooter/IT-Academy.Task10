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
import by.it.academy.task10.services.interfaces.GeneralService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeneralServiceTest {

    private final CourseDao courseDao = new CourseDaoImpl();
    private final TaskDao taskDao = new TaskDaoImpl();
    private final MentorDao mentorDao = new MentorDaoImpl();
    private final UserDao userDao = new UserDAOImpl();
    private final GeneralService generalService = new GeneralServiceImpl();


    @Test
    public void t2_getIdUserTest() {

        Student student = createFirstStudent();
        Mentor mentor = createMentorJava();

        Integer currentIdStudent = generalService.getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME, userDao);
        Integer currentIdMentor = generalService.getIdUser(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA, userDao);

        Assert.assertNotNull(currentIdStudent);
        Assert.assertEquals(currentIdStudent, student.getId());
        Assert.assertEquals(FIRST_STUDENT_NAME, student.getName());
        Assert.assertEquals(FIRST_STUDENT_SURNAME, student.getSurname());

        Assert.assertNotNull(currentIdMentor);
        Assert.assertEquals(currentIdMentor, mentor.getId());
        Assert.assertEquals(MENTOR_NAME_JAVA, mentor.getName());
        Assert.assertEquals(MENTOR_SURNAME_JAVA, mentor.getSurname());
    }

    @Test
    public void t1_getIdTaskTest() {

        Task firstTask = createFirstTask();
        Task secondTask = createSecondTask();

        Integer currentIdFirstTask = generalService.getIdTask(FIRST_TASK, taskDao);
        Integer currentIdSecondTask = generalService.getIdTask(SECOND_TASK, taskDao);

        Assert.assertNotNull(currentIdFirstTask);
        Assert.assertEquals(currentIdFirstTask, firstTask.getId());
        Assert.assertEquals(FIRST_TASK, firstTask.getTitle());

        Assert.assertNotNull(currentIdSecondTask);
        Assert.assertEquals(currentIdSecondTask, secondTask.getId());
        Assert.assertEquals(SECOND_TASK, secondTask.getTitle());
    }

    @Test
    public void t4_getIdCourseTest() {

        Course courseJava = createCourseJava();
        Course coursePython = createCoursePython();

        Integer currentIdJavaCourse = generalService.getIdCourse(TITTLE_JAVA_COURSE, courseDao);
        Integer currentIdJavaPython = generalService.getIdCourse(TITTLE_PYTHON_COURSE, courseDao);

        Assert.assertNotNull(currentIdJavaCourse);
//        Assert.assertEquals(currentIdJavaCourse, courseJava.getId());
        Assert.assertEquals(TITTLE_JAVA_COURSE, courseJava.getTitle());

        Assert.assertNotNull(currentIdJavaPython);
//        Assert.assertEquals(currentIdJavaPython, coursePython.getId());
        Assert.assertEquals(TITTLE_PYTHON_COURSE, coursePython.getTitle());
    }

    @Test
    public void t3_getIdMentorOfCourseTest() {

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

        Integer idMentorOfPythonCourse = generalService
                .getIdMentorOfCourse(TITTLE_PYTHON_COURSE, courseDao);

        Integer idMentorOfJavaCourse = generalService
                .getIdMentorOfCourse(TITTLE_JAVA_COURSE, courseDao);

        Assert.assertNotNull(idMentorOfPythonCourse);
        Assert.assertEquals(idMentorOfPythonCourse, mentorPython.getId());
        Assert.assertEquals(courseSetForPythonMentor, mentorPython.getCourses());

        Assert.assertNotNull(idMentorOfJavaCourse);
        Assert.assertEquals(idMentorOfJavaCourse, mentorJava.getId());
        Assert.assertEquals(courseSetForJavaMentor, mentorJava.getCourses());
    }


    @Test
    public void t5_getIdTaskFromCourseTest() {

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

        Integer currentTaskId = generalService
                .getIdTask(FIRST_TASK, taskDao);

        Assert.assertNotNull(currentTaskId);
//        Assert.assertEquals(currentTaskId, firstTask.getId());
        Assert.assertEquals(courseJava, firstTask.getTaskCourse());
        Assert.assertEquals(taskList, firstTask.getTaskCourse().getTasks());
    }

}