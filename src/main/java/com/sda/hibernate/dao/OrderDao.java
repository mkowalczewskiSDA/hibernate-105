package com.sda.hibernate.dao;

import com.sda.hibernate.model.Order;

import java.util.List;

public interface OrderDao {

    Order findByIdWithReferences(int id);

}
