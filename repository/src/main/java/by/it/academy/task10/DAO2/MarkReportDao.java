package by.it.academy.task10.DAO2;

import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.util.HibernateUtil;

public class MarkReportDao extends DAOBase<MarkReport>{

    public MarkReportDao() {
        super(MarkReport.class, HibernateUtil.getEntityManager());
    }
}
