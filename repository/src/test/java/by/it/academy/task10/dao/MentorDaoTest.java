package by.it.academy.task10.dao;

import by.it.academy.task10.entity.Mentor;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.dao.MockConstants.*;
import static org.junit.Assert.*;

public class MentorDaoTest {

    MentorDao mentorDao = new MentorDao();

    @Test
    public void create() throws SQLException {
        Mentor mentor = Mentor.builder()
                .name(SONIA)
                .surname(VOLKOVA)
                .role(MENTOR)
                .build();
        mentorDao.create(mentor);
        Mentor actualMentor = mentorDao.findOne(mentor.getId());
        assertNotNull(actualMentor);
        assertEquals(mentor.getName(), actualMentor.getName());
        assertEquals(mentor.getSurname(), actualMentor.getSurname());
    }

    @Test
    public void findOne() throws SQLException {
        Mentor mentor = Mentor.builder()
                .name(SONIA)
                .surname(VOLKOVA)
                .role(MENTOR)
                .build();
        mentorDao.create(mentor);
        Mentor actualMentor = mentorDao.findOne(mentor.getId());
        assertNotNull(actualMentor);
        assertEquals(mentor.getName(), actualMentor.getName());
        assertEquals(mentor.getSurname(), actualMentor.getSurname());
    }

    @Test
    public void findAll() throws SQLException {
        Mentor mentor = mentorDao.create(Mentor.builder()
                .name(MAXIM)
                .surname(MAXIMOV)
                .role(STUDENT)
                .build());
        List<Mentor> all = mentorDao.findAll();
        Mentor actualMentor = all.stream()
                .filter(aS -> aS.getName().equals(mentor.getName())
                        && aS.getSurname().equals(mentor.getSurname()))
                .findAny().orElse(null);
        assertNotNull(actualMentor);
        assertEquals(mentor.getName(), actualMentor.getName());
        assertEquals(mentor.getSurname(), actualMentor.getSurname());
    }

    @Test
    public void update() {
        Mentor mentor = Mentor.builder()
                .name(SERGIO)
                .surname(BERLUSKONI)
                .role(STUDENT)
                .build();
        mentorDao.create(mentor);
        mentor.setSurname(NIKANOVICH);
        mentorDao.update(mentor);
        assertEquals(mentor.getSurname(), NIKANOVICH);
    }

    @Test
    public void delete() throws SQLException {
        Mentor mentor = Mentor.builder()
                .name("Vladimir")
                .surname("Lenin")
                .role("Admin")
                .build();
        mentorDao.create(mentor);
        mentorDao.delete(mentor);
        List<Mentor> all = mentorDao.findAll();
        Mentor actualMentor = all.stream()
                .filter(st -> st.getName().equals(mentor.getName())
                        && st.getSurname().equals(mentor.getSurname()))
                .findAny().orElse(null);
        assertNull(actualMentor);
    }

    @Test
    public void deleteById() throws SQLException {
        Mentor mentor = Mentor.builder()
                .name("Nicolai")
                .surname("Romanov")
                .role("Admin")
                .build();
        mentorDao.create(mentor);
        Integer id = mentor.getId();
        mentorDao.deleteById(id);
        List<Mentor> all = mentorDao.findAll();
        Mentor actualMentor = all.stream()
                .filter(st -> st.getName().equals(mentor.getName())
                        && st.getSurname().equals(mentor.getSurname()))
                .findAny().orElse(null);
        assertNull(actualMentor);
    }


}