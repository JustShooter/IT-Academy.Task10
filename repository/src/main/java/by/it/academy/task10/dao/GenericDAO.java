package by.it.academy.task10.dao;

import java.util.List;

public interface GenericDAO <T>{

    List<T> selectAll(T t);

    T selectById(T t, Integer id);

    void insert(T t);

    void update(T t);

    void persist(T t);

    void deleteById(T t, Integer id);


}
