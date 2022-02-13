package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.domain.entity.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface OrderRepository {

    // getOrder
    Order get(UUID id);

    Order create(Order order);

    Order update(Order order);

    void delete(UUID orderId);


    //REPORT PART
    Set<Order> getAll();

    Set<Order> getUserOrders(UUID userId);


}
