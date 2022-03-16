package com.sda.hibernate.przyklad6;

import com.sda.hibernate.model.Address;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> criteriaQuery = builder.createQuery(Address.class);
        //select from Address
        Root<Address> root = criteriaQuery.from(Address.class);
        //tu do naszego criteria query wysyłamy naszego selecta - tu też możemy
        // ustalić warunki zapytania
        //criteriaQuery.setSelect(root) - ustawiamy w criteria query pole "Selection" za pomocą root
        criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);
        List<Address> addressList = query.getResultList();
        addressList.forEach(System.out::println);




    }

}
