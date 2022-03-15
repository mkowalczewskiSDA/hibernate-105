package com.sda.hibernate.dao;

import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class GenericDaoImpl<T> implements GenericDao<T> {


    private Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(int id) {
        Session session = openSession();
        T result =  session.find(entityClass, id);
        session.close();
        return result;
    }

    @Override
    public void insertObject(T t) {

    }

    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
