package com.sda.hibernate.service;

import com.sda.hibernate.model.Order;

public interface OrderService {

    Order reCalculateOrderPrice(int id);

}
