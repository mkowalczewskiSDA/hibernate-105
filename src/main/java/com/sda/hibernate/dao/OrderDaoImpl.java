package com.sda.hibernate.dao;

import com.sda.hibernate.model.Order;

import java.util.List;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

    public OrderDaoImpl() {
        super(Order.class);
    }

    public List<Order> findByDate(){
        return null;
    }

}
