package com.sda.hibernate.przyklad5;

import com.sda.hibernate.model.Address;
import com.sda.hibernate.model.Country;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Country> query = session.createNamedQuery("country.select.all", Country.class);
        List<Country> countryList = query.getResultList();
        countryList.forEach(System.out::println);
        Set<Address> addressSet = countryList.get(0).getAddresses();
        addressSet.forEach(System.out::println);
        session.close();
        //System.out.println(addressSet);
    }

}
