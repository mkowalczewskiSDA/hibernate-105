package com.sda.hibernate.service;

import com.sda.hibernate.dao.OrderDao;
import com.sda.hibernate.model.Order;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order reCalculateOrderPrice(int id) {
        return null;
    }

}
