package com.sda.hibernate.przyklad5;

import com.sda.hibernate.model.Country;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Country> query = session.createNamedQuery("country.select.all", Country.class);
        query.getResultList().forEach(System.out::println);
    }

}
