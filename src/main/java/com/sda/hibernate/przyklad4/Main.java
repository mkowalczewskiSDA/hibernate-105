package com.sda.hibernate.przyklad4;

import com.sda.hibernate.model.Country;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NativeQuery<Country> nativeQuery = session.createNativeQuery(
                "select * from Country where co_name=:name",
                Country.class)
                .setParameter("name", "Japan");

        nativeQuery.getResultList().forEach(System.out::println);
        session.close();
    }
}
