package com.sda.hibernate.przyklad2;

import com.sda.hibernate.model.Country;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        usePersist();
    }

    public static void usePersist() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country = new Country();
        country.setAlias("IN");
        session.beginTransaction();
        session.persist(country);
        country.setName("India");
        session.getTransaction().commit();
        session.close();

    }

}
