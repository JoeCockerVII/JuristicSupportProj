package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.dto.OrderCreateDto;
import com.example.juristicsupport.domain.dto.OrderDto;
import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.domain.mapper.OrderMapper;
import com.example.juristicsupport.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Controller to work with Order
 *
 * @author ilyin
 * @since 14.01.2022
 */

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;
    private final OrderService orderService;

    /**
     * Get order by orderId
     *
     * @param orderId
     * @return JuristDto on JSON format
     */
    @GetMapping("report/orders/{orderId}")
    public Order get(@PathVariable UUID orderId) {
        return orderService.get(orderId);
    }

    /**
     * Add new jurist
     *
     * @param createDto JuristCreateDto
     * @return JuristDto on JSON format
     */
    @PostMapping("users/{userId}/orders")
    public OrderDto create(@PathVariable UUID userId, @RequestBody OrderCreateDto createDto) {

        return Optional.ofNullable(createDto)
                .map(toUpdate -> orderMapper.fromCreateDto(userId, toUpdate))
                .map(orderService::create)
                .map(orderMapper::toDto)
                .orElseThrow();
    }

    /**
     * Delete jurist
     *
     * @param id of jurist
     */
    @DeleteMapping("users/{userId}/orders/{orderId}")
    public void delete(@PathVariable(name = "orderId") UUID id) {
        orderService.delete(id);
    }

    /**
     * Get all of orders on JSON format
     *
     * @return Orders Set on JSON format
     */
    @GetMapping("report/orders")
    public Set<Order> getAll() {
        return orderService.getAll();
    }

    /**
     * Get Orders by User Id
     * @param userId
     * @return Orders Set on JSON format
     */
    @GetMapping("report/users/{userId}/orders")
    public Set<Order> getUserOrders(@PathVariable UUID userId) {
        return orderService.getUserOrders(userId);
    }
}
