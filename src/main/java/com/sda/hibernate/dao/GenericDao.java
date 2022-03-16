package com.sda.hibernate.dao;

import java.util.List;

public interface GenericDao<T> {

    T findById(int id) throws RuntimeException;
    void insertObject(T t);
    void deleteObject(T t);
    void deleteObject(int id);
    List<T> findAll();
    List<T> findAll(int maxResults, int firstResult);

}
