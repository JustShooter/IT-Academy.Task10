package by.it.academy.task10.dao;


import by.it.academy.task10.entity.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.dao.MockConstants.*;
import static org.junit.Assert.*;

public class AdminDaoTest {

    private final GenericDAO<Student> studentDao = new StudentDao();

    @Test
    public void create() throws SQLException {
        Student student = Student.builder()
                .name(SONIA)
                .surname(VOLKOVA)
                .role(STUDENT)
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
                .role(STUDENT)
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
                .role(STUDENT)
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
                .role(STUDENT)
                .build();
        studentDao.create(student);
        student.setSurname(NIKANOVICH);
        studentDao.update(student);
        assertEquals(student.getSurname(), NIKANOVICH);
    }

    @Test
    public void delete() throws SQLException {
        Student student = Student.builder()
                .name("Vladimir")
                .surname("Lenin")
                .role("Admin")
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
                .name("Nicolai")
                .surname("Romanov")
                .role("Admin")
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