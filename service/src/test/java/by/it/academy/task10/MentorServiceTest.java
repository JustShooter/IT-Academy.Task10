package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.*;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.MockConstants.*;
import static by.it.academy.task10.MockUtils.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MentorServiceTest {
    GeneralService generalService;
    private Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);
    private Dao<Student> studentDao = new Dao<>(Student.class);
    private Dao<Task> taskDao = new Dao<>(Task.class);
    private Dao<MarkReport> markReportDao = new Dao<>(MarkReport.class);


    AdminService adminService = new AdminService();
    MentorService mentorService = new MentorService();

    @Test
    void taskShouldBeCreatedTest() {
        try {
            mentorService.createTask(TITTLE_PYTHON_COURSE,FIRST_TASK);
            boolean taskIsCreated = false;
            List<Task> taskList = taskDao.findAll();
            for (Task task : taskList){
                taskIsCreated = true;
            }
            assertNotNull(GeneralService.getIdTask(FIRST_TASK));
            assertTrue(taskIsCreated, "Task not created");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
