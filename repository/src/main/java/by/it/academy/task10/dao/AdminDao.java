package by.it.academy.task10.dao;

import by.it.academy.task10.dao.Interfaces.AdminDaoInt;
import by.it.academy.task10.entity.Admin;
import by.it.academy.task10.util.HibernateUtil;

public class AdminDao extends AbstractDAO<Admin> implements AdminDaoInt {

    public AdminDao() {
        super(Admin.class, HibernateUtil.getEntityManager());
    }
}
