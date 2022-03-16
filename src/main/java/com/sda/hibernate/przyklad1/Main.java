package com.sda.hibernate.przyklad1;

import com.sda.hibernate.dao.GenericDao;
import com.sda.hibernate.dao.GenericDaoImpl;
import com.sda.hibernate.model.Address;
import com.sda.hibernate.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Address address = session.find(Address.class, 1);
        //System.out.println(address.getCountry());
        session.close();
        System.out.println(address);

        sessionFactory.close();

        GenericDao<Country> countryDao = new GenericDaoImpl<>(Country.class);
        Country country = new Country();
        country.setId(1);
        countryDao.deleteObject(country);

    }
}
