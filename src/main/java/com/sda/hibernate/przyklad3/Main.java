package com.sda.hibernate.przyklad3;

import com.sda.hibernate.model.Address;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Address> query = session.createQuery(
                "select a from Address a where a.city = :city",
                Address.class)
                .setParameter("city", "test");

        List<Address> addressList = query.getResultList();

        Query<Address> query2 = session.createQuery(
                "select o from Order o join fetch o.user  " +
                        "where c.alias = :alias",
                Address.class
        ).setParameter("alias", "PL");

        List<Address> addressListJoin = query2.getResultList();

        //addressList.forEach(System.out::println);

        session.beginTransaction();
        addressList.get(0).setPostalCode("test23");
        addressListJoin.get(0).getCountry().setAlias("PL");
        session.getTransaction().commit();

        session.close();

        addressListJoin.forEach(System.out::println);

    }

}
