package by.it.academy.task10;


import by.it.academy.task10.dao.Interfaces.GenericDAO;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.interfaces.StudentDao;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.MockConstants.*;
import static org.junit.Assert.*;

public class AdminDaoTest {

    private final StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void create() throws SQLException {
        Student student = Student.builder()
                .name(SONIA)
                .surname(VOLKOVA)
                .build();
        studentDao.create(student);
        Student actualStudent = studentDao.findOne(student.getId());
        assertNotNull(actualStudent);
        assertEquals(student.getName(), actualStudent.getName());
        assertEquals(student.getSurname(), actualStudent.getSurname());
    }

    @Test
    public void findOne() throws SQLException {
        Student student = Student.builder()
                .name(SASHA)
                .surname(BORSIK)
                .build();
        studentDao.create(student);
        Student actualStudent = studentDao.findOne(student.getId());
        assertNotNull(actualStudent);
        assertEquals(student.getName(), actualStudent.getName());
        assertEquals(student.getSurname(), actualStudent.getSurname());
    }

    @Test
    public void findAll() throws SQLException {
        Student student = studentDao.create(Student.builder()
                .name(MAXIM)
                .surname(MAXIMOV)
                .build());
        List<Student> all = studentDao.findAll();
        Student actualStudent = all.stream()
                .filter(aS -> aS.getName().equals(student.getName())
                        && aS.getSurname().equals(student.getSurname()))
                .findAny().orElse(null);
        assertNotNull(actualStudent);
        assertEquals(student.getName(), actualStudent.getName());
        assertEquals(student.getSurname(), actualStudent.getSurname());
    }

    @Test
    public void update() {
        Student student = Student.builder()
                .name(SERGIO)
                .surname(BERLUSKONI)
                .build();
        studentDao.create(student);
        student.setSurname(NIKANOVICH);
        studentDao.update(student);
        assertEquals(student.getSurname(), NIKANOVICH);
    }

    @Test
    public void delete() throws SQLException {
        Student student = Student.builder()
                .name(VLADIMIR)
                .surname("Lenin")
                .build();
        studentDao.create(student);
        studentDao.delete(student);
        List<Student> all = studentDao.findAll();
        Student actualStudent = all.stream()
                .filter(st -> st.getName().equals(student.getName())
                        && st.getSurname().equals(student.getSurname()))
                .findAny().orElse(null);
        assertNull(actualStudent);
    }

    @Test
    public void deleteById() throws SQLException {
        Student student = Student.builder()
                .name(NICOLAI)
                .surname(ROMANOV)
                .build();
        studentDao.create(student);
        Integer id = student.getId();
        studentDao.deleteById(id);
        List<Student> all = studentDao.findAll();
        Student actualStudent = all.stream()
                .filter(st -> st.getName().equals(student.getName())
                        && st.getSurname().equals(student.getSurname()))
                .findAny().orElse(null);
        assertNull(actualStudent);
    }

}