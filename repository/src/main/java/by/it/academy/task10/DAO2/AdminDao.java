package by.it.academy.task10.DAO2;

import by.it.academy.task10.entity.Admin;
import by.it.academy.task10.util.HibernateUtil;

public class AdminDao extends DAOBase<Admin>{

    public AdminDao() {
        super(Admin.class, HibernateUtil.getEntityManager());
    }
}
