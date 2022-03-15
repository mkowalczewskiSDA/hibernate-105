package com.sda.hibernate.dao;

public interface GenericDao<T> {

    T findById(int id);
    void insertObject(T t);

}
