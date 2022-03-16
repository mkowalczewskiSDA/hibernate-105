package com.sda.hibernate.przyklad6;

import com.sda.hibernate.model.Address;
import com.sda.hibernate.model.Address_;
import com.sda.hibernate.model.Country;
import com.sda.hibernate.model.Country_;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {

    //Root                          criteriaBuilder
    //Select from nazwa_tabeli      where / group by / order by / distinct / having

    //builder
    // = / > / < / >= / <= / between

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String street = "Gdanska";
        String alias = "PL";

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> criteriaQuery = builder.createQuery(Address.class);
        //select from Address
        Root<Address> root = criteriaQuery.from(Address.class);
        //Join<Address, Country> join = root.join(Address_.country);
        criteriaQuery.where(
                builder.equal(
                        //join.get(Country_.alias),
                        root.join(Address_.country)
                                .get(Country_.alias),
                        alias
                )
        );
        //tu do naszego criteria query wysyłamy naszego selecta - tu też możemy
        // ustalić warunki zapytania
        //criteriaQuery.setSelect(root) - ustawiamy w criteria query
        //pole "Selection" za pomocą root
        //criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);
        List<Address> addressList = query.getResultList();
        addressList.forEach(System.out::println);




    }

}
