package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.Order;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ReportService {

    Map<UUID, Order> getAll();

    Order getOrder(UUID orderId);

    List<Order> getUserOrders(UUID userId);
}
