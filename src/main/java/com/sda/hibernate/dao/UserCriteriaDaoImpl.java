package com.sda.hibernate.dao;

import com.sda.hibernate.model.*;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;

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

        Query query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

}
