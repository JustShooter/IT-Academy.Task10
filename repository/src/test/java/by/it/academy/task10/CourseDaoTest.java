package by.it.academy.task10;

import by.it.academy.task10.entity.Course;
import by.it.academy.task10.dao.implementations.CourseDaoImpl;
import by.it.academy.task10.dao.interfaces.CourseDao;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.MockConstants.*;
import static org.junit.Assert.*;

public class CourseDaoTest {

    private CourseDao courseDao = new CourseDaoImpl();

    @Test
    public void create() throws SQLException {
        Course course = Course.builder()
                .title(PHP)
                .build();
        courseDao.create(course);
        Course actualCourse = courseDao.findOne(course.getId());
        assertNotNull(actualCourse);
        assertEquals(course.getTitle(), actualCourse.getTitle());
    }

    @Test
    public void findOne() throws SQLException {
        Course course = Course.builder()
                .title(JAVA)
                .build();
        courseDao.create(course);
        Course actualCourse = courseDao.findOne(course.getId());
        assertNotNull(actualCourse);
        assertEquals(course.getTitle(), actualCourse.getTitle());
    }

    @Test
    public void findAll() throws SQLException {
        Course course = Course.builder()
                .title(PYTNON)
                .build();
        courseDao.create(course);
        List<Course> all = courseDao.findAll();
        Course actualCourse = all.stream()
                .filter(aS -> aS.getTitle().equals(course.getTitle()))
                .findAny().orElse(null);
        assertNotNull(actualCourse);
        assertEquals(course.getTitle(), actualCourse.getTitle());
    }

    @Test
    public void update() {
        Course course = Course.builder()
                .title(C)
                .build();
        courseDao.create(course);
        course.setTitle(NIKANOVICH);
        courseDao.update(course);
        assertEquals(course.getTitle(), NIKANOVICH);
    }

    @Test
    public void delete() throws SQLException {
        Course course = Course.builder()
                .title(C)
                .build();
        courseDao.create(course);
        courseDao.delete(course);
        List<Course> all = courseDao.findAll();
        Course actualCourse = all.stream()
                .filter(aS -> aS.getTitle().equals(course.getTitle()))
                .findAny().orElse(null);
        assertNull(actualCourse);
    }

    @Test
    public void deleteById() throws SQLException {
        Course course = Course.builder()
                .title(PASKAL)
                .build();
        courseDao.create(course);
        Integer id = course.getId();
        courseDao.deleteById(id);
        List<Course> all = courseDao.findAll();
        Course actualCourse = all.stream()
                .filter(st -> st.getTitle().equals(course.getTitle()))
                .findAny().orElse(null);
        assertNull(actualCourse);
    }


}