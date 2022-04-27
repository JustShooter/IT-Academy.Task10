package by.it.academy.task10.DAO;

import by.it.academy.task10.entity.Admin;
import by.it.academy.task10.util.HibernateUtil;

public class AdminDao extends AbstractDAO<Admin> {

    public AdminDao() {
        super(Admin.class, HibernateUtil.getEntityManager());
    }
}
