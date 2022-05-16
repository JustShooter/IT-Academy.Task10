package by.it.academy.task10;

import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.dao.implementations.MentorDaoImpl;
import by.it.academy.task10.dao.interfaces.MentorDao;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.MockConstants.*;
import static org.junit.Assert.*;

public class MentorDaoTest {

    MentorDao mentorDao = new MentorDaoImpl();

    @Test
    public void create() throws SQLException {
        Mentor mentor = Mentor.builder()
                .name(SONIA)
                .surname(VOLKOVA)
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
                .build();
        mentorDao.create(mentor);
        mentor.setSurname(NIKANOVICH);
        mentorDao.update(mentor);
        assertEquals(mentor.getSurname(), NIKANOVICH);
    }

    @Test
    public void delete() throws SQLException {
        Mentor mentor = Mentor.builder()
                .name(VLADIMIR)
                .surname(LENIN)
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
                .name(NICOLAI)
                .surname(ROMANOV)
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