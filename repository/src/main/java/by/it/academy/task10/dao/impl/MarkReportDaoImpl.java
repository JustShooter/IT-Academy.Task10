package by.it.academy.task10.dao.impl;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.interf.MarkReportDao;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.util.HibernateUtil;

public class MarkReportDaoImpl extends GenericDaoImpl<MarkReport> implements MarkReportDao {

    public MarkReportDaoImpl() {
        super(MarkReport.class, HibernateUtil.getEntityManager());
    }
}
