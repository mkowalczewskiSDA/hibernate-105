package com.sda.hibernate.service;

import com.sda.hibernate.dao.OrderDao;
import com.sda.hibernate.model.Cart;
import com.sda.hibernate.model.Order;

import java.math.BigDecimal;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order reCalculateOrderPrice(int id) {
        Order order = orderDao.findByIdWithReferences(id);
        double sum = order.getCartValues().stream()
                //.map(cart -> countProductQuantityPrice(cart))
                .map(this::countProductQuantityPrice)
                .mapToDouble(Double::doubleValue)
                .sum();
        order.setPrice(BigDecimal.valueOf(sum));
        return order;
    }

    private double countProductQuantityPrice(Cart cart) {
        return cart.getQuantity() * cart.getProduct().getPrice().doubleValue();
    }

}
