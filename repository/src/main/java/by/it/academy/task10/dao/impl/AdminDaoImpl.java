package by.it.academy.task10.dao.impl;

import by.it.academy.task10.dao.GenericDaoImpl;
import by.it.academy.task10.dao.interf.AdminDao;
import by.it.academy.task10.entity.Admin;
import by.it.academy.task10.util.HibernateUtil;

import javax.persistence.EntityManager;

public class AdminDaoImpl extends GenericDaoImpl<Admin> implements AdminDao {

    public AdminDaoImpl() {
        super(Admin.class, HibernateUtil.getEntityManager());
    }
}
