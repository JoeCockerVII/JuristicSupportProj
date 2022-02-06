package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Order;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface OrderRepository {

//    Order get(UUID id);

    Map<UUID, Order> getAll();

    Order getOrder(UUID orderId);

    List<Order> getUserOrders(UUID userId);

    Order create(Order user);

}
