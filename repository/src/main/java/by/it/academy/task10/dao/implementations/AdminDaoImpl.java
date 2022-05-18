package by.it.academy.task10.dao.implementations;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.Interfaces.AdminDao;
import by.it.academy.task10.entity.Admin;
import by.it.academy.task10.util.HibernateUtil;

public class AdminDaoImpl extends GenericDaoImpl<Admin> implements AdminDao{

    public AdminDaoImpl() {
        super(Admin.class, HibernateUtil.getEntityManager());
    }
}
