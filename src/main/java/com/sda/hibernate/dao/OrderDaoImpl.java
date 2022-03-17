package com.sda.hibernate.dao;

import com.sda.hibernate.model.Order;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDaoImpl implements OrderDao  {


    @Override
    public Order findByIdWithReferences(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Order> query = session.createQuery(
                "from Order o join fetch o.cartValues c join fetch c.product o.id = :id",
                Order.class
        ).setParameter("id", id);
        Order result = query.getSingleResult();
        session.close();
        return result;
    }
}
