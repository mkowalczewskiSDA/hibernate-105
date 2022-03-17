package com.sda.hibernate.dao;

import com.sda.hibernate.model.*;
import com.sda.hibernate.model.Order;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

//https://www.baeldung.com/hibernate-criteria-queries

public class UserCriteriaDaoImpl implements UserCriteriaDao {

    private Session session;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<User> criteriaQuery;

    private Root<User> getRoot() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteriaBuilder = session.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(User.class);
        return criteriaQuery.from(User.class);
    }

    @Override
    public List<User> findUserWhereLastNameContains(String s) {
        Root<User> root = getRoot();
        criteriaQuery.where(criteriaBuilder.like(root.get(User_.lastName), "%" + s + "%"));
        Query<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    //Address i Country ma być zaciągnięte do obiektu
    @Override
    public List<User> findAllByCountryAlias(String alias) {
        Root<User> root = getRoot();
        root.fetch(User_.address)
            .fetch(Address_.country);

        criteriaQuery.where(criteriaBuilder.equal(
                root.get(User_.address)
                        .get(Address_.country)
                        .get(Country_.alias) ,
                alias));

        Query<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public List<User> findAllBornBetween(LocalDate date1, LocalDate date2) {
        Root<User> root = getRoot();
        criteriaQuery.where(criteriaBuilder.between(root.get(User_.birthDate), date1, date2));
        Query<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public List<User> findAllWhoBoughtProduct(Product product) {
        Root<User> root = getRoot();
        Join<User, Order> orderJoin = root.join(User_.orders);
        Join<Order, Product> productJoin = orderJoin.join(Order_.products);
        criteriaQuery.where(criteriaBuilder.equal(productJoin, product));
        Query<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public List<User> findAllWhoBoughtProductHql(Product product) {
        return null;
    }

}
