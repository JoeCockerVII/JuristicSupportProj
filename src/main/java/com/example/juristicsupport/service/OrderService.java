package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.Order;

import java.util.Set;
import java.util.UUID;

public interface OrderService {

    Order get(UUID orderId);

    Order create(Order order);

    Order update(UUID id, Order order);

    void delete(UUID orderId);

    //REPORT PART
    Set<Order> getAll();

    Set<Order> getUserOrders(UUID userId);


}
