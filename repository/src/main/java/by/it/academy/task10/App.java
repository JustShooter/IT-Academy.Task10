package by.it.academy.task10;

import by.it.academy.task10.util.HibernateUtil;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager manager = HibernateUtil.getEntityManager();
    }
}
