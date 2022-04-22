package by.it.academy.task10.dao;

import by.it.academy.task10.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class Dao<T> implements GenericDao<T> {
    private final Class<T> clazz;
    private final EntityManager entityManager;


    public Dao(Class<T> incomingClass) {
        this.clazz = incomingClass;
        this.entityManager = HibernateUtil.getEntityManager();
    }


    @Override
    public T findOne(final Object id) throws SQLException {
        T entity = entityManager.find(clazz, id);
        if(entity==null){
            throw new SQLException("No such id found!");
        }
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public T create(final T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public T update(final T incomingEntity) {
        entityManager.getTransaction().begin();
        T entity = entityManager.merge(incomingEntity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(final T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(final long entityId) throws SQLException {
        final T entity = findOne(entityId);
        entityManager.getTransaction().begin();
        delete(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void closeAll(){
        entityManager.close();
        HibernateUtil.close();
    }
}