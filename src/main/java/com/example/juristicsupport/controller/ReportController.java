package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Controller to show information report about orders
 *
 * @author ilyin
 * @since 29.01.2022
 */

@RestController
//path = http://localhost:8080/api/v1.0/reports
@RequestMapping(path = "reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    /**
     * Get All Orders
     */
    @GetMapping("/orders")
    public Map<UUID, Order> getAll() {
        return reportService.getAll();
    }

    /**
     * Get Order by ID
     */
    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable UUID orderId) {
        return reportService.getOrder(orderId);
    }

    /**
     * Get User Orders by his ID
     */
    @GetMapping("/users/{userId}/orders")
    public List<Order> getUserOrders(@PathVariable UUID userId) {
        return reportService.getUserOrders(userId);
    }
}
