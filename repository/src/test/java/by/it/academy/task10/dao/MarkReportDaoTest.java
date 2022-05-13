package by.it.academy.task10.dao;

import by.it.academy.task10.entity.MarkReport;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static by.it.academy.task10.dao.MockConstants.*;
import static org.junit.Assert.*;

public class MarkReportDaoTest {

    private MarkReportDao markReportDao = new MarkReportDao();

    @Test
    public void create() throws SQLException {
        MarkReport markReport = MarkReport.builder()
                .mark(MARK)
                .build();
        markReportDao.create(markReport);
        MarkReport actualMarkReport = markReportDao.findOne(markReport.getId());
        assertNotNull(actualMarkReport);
        assertEquals(markReport.getMark(), actualMarkReport.getMark());
    }

    @Test
    public void findOne() throws SQLException {
        MarkReport markReport = MarkReport.builder()
                .mark(MARK1)
                .build();
        markReportDao.create(markReport);
        MarkReport actualMarkReport = markReportDao.findOne(markReport.getId());
        assertNotNull(actualMarkReport);
        assertEquals(markReport.getMark(), actualMarkReport.getMark());
    }

    @Test
    public void findAll() throws SQLException {
        MarkReport markReport = MarkReport.builder()
                .mark(MARK2)
                .build();
        markReportDao.create(markReport);
        List<MarkReport> all = markReportDao.findAll();
        MarkReport actualMarkReport = all.stream()
                .filter(aS -> aS.getMark().equals(markReport.getMark()))
                .findAny().orElse(null);
        assertNotNull(actualMarkReport);
        assertEquals(markReport.getMark(), actualMarkReport.getMark());
    }

    @Test
    public void update() {
        MarkReport markReport = MarkReport.builder()
                .mark(MARK3)
                .build();
        markReportDao.create(markReport);
        markReport.setMark(MARK);
        markReportDao.update(markReport);
        assertEquals(markReport.getMark(), MARK);
    }

    @Test
    public void delete() throws SQLException {
        MarkReport markReport = MarkReport.builder()
                .mark(MARK4)
                .build();
        markReportDao.create(markReport);
        markReportDao.delete(markReport);
        List<MarkReport> all = markReportDao.findAll();
        MarkReport actualMarkReport = all.stream()
                .filter(st -> st.getMark().equals(markReport.getMark()))
                .findAny().orElse(null);
        assertNull(actualMarkReport);
    }

    @Test
    public void deleteById() throws SQLException {
        MarkReport markReport = MarkReport.builder()
                .mark(MARK5)
                .build();
        markReportDao.create(markReport);
        Integer id = markReport.getId();
        markReportDao.deleteById(id);
        List<MarkReport> all = markReportDao.findAll();
        MarkReport actualMarkReport = all.stream()
                .filter(st -> st.getMark().equals(markReport.getMark()))
                .findAny().orElse(null);
        assertNull(actualMarkReport);
    }

}