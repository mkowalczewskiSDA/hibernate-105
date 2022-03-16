package com.sda.hibernate.przyklad2;

import com.sda.hibernate.model.Address;
import com.sda.hibernate.model.Country;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        //usePersist();
        //useMerge();
        //useUpdate();
        //useDelete();
        usePersistCascade();
    }

    public static void usePersist() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country = new Country();
        country.setAlias("IN");
        session.beginTransaction();
        //persist dodaje nam obiekt do persistance contextu - pod spodem dokonuje się "insert"
        //nasz obiekt country dostaje swój numer id
        session.persist(country);
        //jeżeli obiekt jest już spersistowany, a my go zmieniamy, to podczas wykonywania
        //commita dokona się Update
        country.setName("India");
        //jeżeli mamy bardzo dużo wierszy do dodania, i chcemy część tej operacji już wykonać
        //(żeby np zwolnić trochę pamięci, to możemy wykonać flush)
        //zapisuje nam transakcję
        session.getTransaction().commit();
        session.close();

    }

    private static void useMerge() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country = new Country();
        country.setId(2);
        country.setName("Ukraine");
        session.beginTransaction();
        country = (Country) session.merge(country);
        //country.setAlias("UA");
        session.getTransaction().commit();
        session.close();
    }

    private static void useUpdate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = new Country();
        country.setId(3);
        country.setName("Japan");
        session.update(country);
        country.setAlias("JP");
        session.getTransaction().commit();
        session.close();
    }

    private static void useDelete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = new Country(); //session.find(Country.class, 4);
        country.setId(4);
        session.delete(country);
        session.getTransaction().commit();
        session.close();
    }

    public static void usePersistCascade() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country = new Country();
        country.setAlias("Test");
        country.setName("Country");
        Address address = new Address();
        address.setStreet("test");
        address.setCity("test");
        address.setBuildingNo("1");
        address.setApartmentNo("1");
        address.setPostalCode("00-000");
        address.setCountry(country);
        session.beginTransaction();
        session.persist(address);
        session.getTransaction().commit();
        session.close();
    }

}
