package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.util.HibernateUtil;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class GeneralServiceTest {

    AdminService as = new AdminService();
    MentorService ms = new MentorService();
    GeneralService gs = new GeneralService();
    private Dao<Student> studentDao = new Dao<>(Student.class);
    Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    Dao<Course> courseDao = new Dao<>(Course.class);
    private Dao<Task> taskDao = new Dao<>(Task.class);


    @Before
    public void init() throws SQLException {

    }

    @Test
    public void getIdUserSuccessfully() {
        assertNotNull(gs.getIdUser("Жанна", "Колесень"));
    }

    @Test
    public void getIdUserFailure() {
        assertNull(gs.getIdUser("Джошуа", "Бин"));
    }

    @Test
    public void getIdTaskSuccessfully() {
        assertNotNull(gs.getIdTask("Arrays"));
    }

    @Test
    public void getIdCourse() {

    }

    @Test
    public void getIdTaskFromCourse() {
    }
}