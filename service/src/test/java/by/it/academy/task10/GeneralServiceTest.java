package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;

class GeneralServiceTest {

    private Dao<User> userDao = new Dao<>(User.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);
    private Dao<Task> taskDao = new Dao<>(Task.class);
    private final Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    private Dao<Student> studentDao = new Dao<>(Student.class);
    private Dao<MarkReport> markReportDao = new Dao<>(MarkReport.class);


    AdminService adminService = new AdminService();

    @Test
    void getIdFromCurrentUserTest() {

        adminService.createStudent(NAME_USER, SURNAME_USER);
        adminService.createMentor(MENTOR_NAME_JAVA, MENTOR_SURNAME_JAVA);

        User userEntity = Student.builder()
                .name(FIRST_STUDENT_NAME)
                .surname(FIRST_STUDENT_SURNAME)
                .role("Student")
                .build();
        userDao.create(userEntity);

        Integer idCurrentUserEntity = GeneralService
                .getIdUser(FIRST_STUDENT_NAME, FIRST_STUDENT_SURNAME);

        Assertions.assertNotNull(userEntity);
        Assertions.assertNotNull(userEntity.getId());
        Assertions.assertEquals(userEntity.getId(), idCurrentUserEntity, "Id != 3");
    }

    @Test
    void getIdFromTaskTest() {

        taskDao.create(createFirstTask());
        taskDao.create(createSecondTask());

        Integer currentTaskId = GeneralService.getIdTask(SECOND_TASK);

        Assertions.assertNotNull(currentTaskId);
        Assertions.assertEquals(2, currentTaskId, "Id != 2");

    }

    @Test
    void getIdFromCourseTest() {
        adminService.createCourse(COURSE_TITTLE_JAVA);
        adminService.createCourse(COURSE_TITLE_PYTHON);

        Integer idCurrentCourse = GeneralService.getIdCourse(COURSE_TITLE_PYTHON);

        Assertions.assertNotNull(idCurrentCourse);
        Assertions.assertEquals(2, idCurrentCourse, "Id != 2");
    }

    @Test
    void getIdMentorFromCourseTest() {

        Mentor mentorJava = mentorDao.create(createMentorJava());
        Mentor mentorPython = mentorDao.create(createMentorPython());
        Course ruby = courseDao.create(createCourseRuby());
        Course python = courseDao.create(createCoursePython());

        mentorPython.setCourseMentor(python);
        python.setMentorCourse(mentorPython);

        mentorDao.update(mentorPython);
        courseDao.update(python);

        Integer currentMentorId = GeneralService
                .getIdMentorOfCourse(TITTLE_PYTHON_COURSE);

        Assertions.assertNotNull(currentMentorId);
        Assertions.assertEquals(mentorPython.getId(),
                GeneralService.getIdMentorOfCourse(TITTLE_PYTHON_COURSE),
                "Id != 2");
    }


    @Test
        // getIdTaskFromCourse
    void getTaskIdFromCourseTest() {
        //TODO
    }

    @Test
        // getIdReport
    void getIdFromReport() {

        //TODO

        /*Course python = courseDao.create(createCoursePython());
        Student student =  studentDao.create(createFirstStudent());

        Task firstTask = taskDao.create(createFirstTask());
        taskDao.create(createSecondTask());



        Mentor mentorPython = mentorDao.create(createMentorPython());
        MarkReport markReport = MarkReport.builder()
                .mentor(mentorPython)
                .student(student)
                .task(firstTask)
                .mark(8)
                .feedback("message")
                .build();

        markReportDao.create(markReport);
        Set<MarkReport> markReports = new HashSet<>();
        markReports.add(markReport);


        mentorPython.setMarkReports(markReports);
        mentorDao.update(mentorPython);
          try {
              GeneralService.getIdReport(FIRST_STUDENT_NAME,FIRST_STUDENT_SURNAME,FIRST_TASK,TITTLE_PYTHON_COURSE);
          } catch (SQLException e) {
              e.printStackTrace();
          }*/


    }
}