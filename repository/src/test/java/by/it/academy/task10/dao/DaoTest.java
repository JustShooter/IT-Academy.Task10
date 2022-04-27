package by.it.academy.task10.dao;

import by.it.academy.task10.DAO.GenericDAO;
import by.it.academy.task10.DAO.StudentDao;
import by.it.academy.task10.entity.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class DaoTest {

    GenericDAO<Student> studentDao = new StudentDao();
    Student student = Student.builder()
            .name("Sonia")
            .surname("Volkova")
            .role("Student")
            .build();

    @Test
    public void create() throws SQLException {
        Student student1 = studentDao.create(this.student);
        student1.setName("Victor");
        Integer id = student1.getId();
        studentDao.update(student1);
        Student student2 = studentDao.findOne(id);
        assertEquals(student.getName(), "Victor");
    }

    @Test
    public void findOne() throws SQLException {
        Student student1 = studentDao.create(Student.builder()
                .name("Sasha")
                .surname("Borsik")
                .role("Student")
                .build());
        Integer id = student1.getId();
        assertEquals(student1, studentDao.findOne(id));
    }

    @Test
    public void findAll() throws SQLException {
        Student student1 = studentDao.create(Student.builder()
                .name("Maxim")
                .surname("Maximov")
                .role("Student")
                .build());
        List<Student> all = studentDao.findAll();
        Student s = all.stream()
                .filter(st -> st.getName().equals(student1.getName())
                        && st.getSurname().equals(student1.getSurname()))
                .findAny().orElse(null);
        assertNotNull(s);
    }

    @Test
    public void update() {
        Student student1 = studentDao.create(Student.builder()
                .name("Sergio")
                .surname("Berluskoni")
                .role("Student")
                .build());
        Student student2 = studentDao.create(student1);
        student1.setRole("Mentor");
        studentDao.update(student1);
        assertEquals(student1.getRole(), student2.getRole());
    }

    @Test
    public void delete() throws SQLException {
        Student student1 = studentDao.create(Student.builder()
                .name("Vladimir")
                .surname("Lenin")
                .role("Admin")
                .build());
        Integer id = student1.getId();
        studentDao.delete(student1);
        List<Student> all = studentDao.findAll();
        Student s = all.stream()
                .filter(st -> st.getName().equals(student1.getName())
                        && st.getSurname().equals(student1.getSurname()))
                .findAny().orElse(null);
        assertNull(s);
    }

    @Test
    public void deleteById() throws SQLException {
        Student student1 = studentDao.create(Student.builder()
                .name("Nicolai")
                .surname("Romanov")
                .role("Admin")
                .build());
        Integer id = student1.getId();
        studentDao.deleteById(id);
        List<Student> all = studentDao.findAll();
        Student s = all.stream()
                .filter(st -> st.getName().equals(student1.getName())
                        && st.getSurname().equals(student1.getSurname()))
                .findAny().orElse(null);
        assertNull(s);
    }
}