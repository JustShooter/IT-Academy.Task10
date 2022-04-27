package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import org.junit.jupiter.api.Test;

import static by.it.academy.task10.MockConstants.NAME_USER;
import static by.it.academy.task10.MockConstants.SURNAME_USER;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryServiceTest {
    public static final String STUDENT = "Student";
    public static final String MENTOR = "Mentor";
    private final Dao<Student> studentDao = new Dao<>(Student.class);
    private final Dao<Course> courseDao = new Dao<>(Course.class);
    private final Dao<Mentor> mentorDao = new Dao<>(Mentor.class);



    @Test
    void studentShouldBeAdded(){

        RepositoryService repositoryService = new RepositoryService();

        repositoryService.addStudent("111", "234");

        Integer idStudent = GeneralService.getIdUser("111","234");
        System.out.println(idStudent);
        //TODO



    }
}