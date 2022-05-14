package by.it.academy.task10.dao;

import by.it.academy.task10.dao.Interfaces.MarkReportDaoInt;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.util.HibernateUtil;

public class MarkReportDao extends AbstractDAO<MarkReport> implements MarkReportDaoInt {

    public MarkReportDao() {
        super(MarkReport.class, HibernateUtil.getEntityManager());
    }
}
