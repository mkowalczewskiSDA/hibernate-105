package com.sda.hibernate.dao;

import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
        Session session = openSession();
        session.beginTransaction();
        session.persist(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteObject(T t) {
        Session session = openSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteObject(int id) {
        T t = findById(id);
        if (t != null) {
            deleteObject(t);
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = openSession()) {
            return session.createQuery("from "+entityClass.getName(),
                    entityClass)
                    .getResultList();
        }
    }

    @Override
    public List<T> findAll(int maxResults, int firstResult) {
        return null;
    }

    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
