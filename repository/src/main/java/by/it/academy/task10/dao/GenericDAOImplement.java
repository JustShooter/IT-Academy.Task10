package by.it.academy.task10.dao;

import java.util.List;

public class GenericDAOImplement<T> implements GenericDAO<T>{

    @Override
    public List<T> selectAll(T t) {
        return null;
    }

    @Override
    public T selectById(T t, Integer id) {
        return null;
    }

    @Override
    public void insert(T t) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public void persist(T t) {

    }


    @Override
    public void deleteById(T t, Integer id) {

    }
}
