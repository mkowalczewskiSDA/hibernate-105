package com.sda.hibernate.przyklad1;

import com.sda.hibernate.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Country country = session.find(Country.class, 1);
        System.out.println(country.toString());

        session.close();
        sessionFactory.close();

    }
}
