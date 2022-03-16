package com.sda.hibernate.dao;

public interface GenericDao<T> {

    T findById(int id);
    void insertObject(T t);
    public void deleteObject(T t);
    public void deleteObject(int id);

}
