package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.service.OrderService;
import com.example.juristicsupport.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Service to work with orders report
 *
 * @author ilyin
 * @since 29.01.2022
 */

@Service
@Primary
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final OrderService orderService;

    /**
     * Get All Orders
     */
    public Map<UUID, Order> getAll() {
        return orderService.getAll();
    }

    /**
     * Get Order by ID
     */
    public Order getOrder(UUID orderId) {
        return orderService.getOrder(orderId);
    }

    /**
     * Get User Orders by his ID
     */
    public List<Order> getUserOrders(UUID userId) {
        return orderService.getUserOrders(userId);
    }

}
