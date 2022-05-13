package by.it.academy.task10.dao;

import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.util.HibernateUtil;

public class MarkReportDao extends AbstractDAO<MarkReport> {

    public MarkReportDao() {
        super(MarkReport.class, HibernateUtil.getEntityManager());
    }
}
