package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.dto.OrderCreateDto;
import com.example.juristicsupport.domain.dto.OrderDto;
import com.example.juristicsupport.domain.exception.EntityNotFoundException;
import com.example.juristicsupport.domain.mapper.OrderMapper;
import com.example.juristicsupport.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public OrderDto get(@PathVariable UUID orderId) {
        return Optional.of(orderId)
                .map(orderService::get)
                .map(orderMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(orderId, "Order"));
    }

    /**
     * Add new order
     *
     * @param createDto orderCreateDto
     * @return OrderDto on JSON format
     */
    @PostMapping("users/{userId}/orders")
    public OrderDto create(@PathVariable UUID userId, @RequestBody OrderCreateDto createDto) {

        return Optional.ofNullable(createDto)
                .map(orderMapper::fromCreateDto)
                .map(current -> orderService.create(userId, current))
                .map(orderMapper::toDto)
                .orElseThrow();
    }

    /**
     * Delete order
     *
     * @param userId
     * @param orderId
     */
    @DeleteMapping("users/{userId}/orders/{orderId}")
    public void delete(@PathVariable UUID userId, @PathVariable UUID orderId) {
        orderService.delete(userId, orderId);
    }

    /**
     * Get all of orders on JSON format
     *
     * @param pageable
     * @return Orders Set on JSON format
     */
    @GetMapping("report/orders")
    public Page<OrderDto> getAll(Pageable pageable) {
        return Optional.of(pageable)
                .map(it -> orderService.getAll(pageable))
                .map(it -> it.map(orderMapper::toDto))
                .orElseThrow();
    }

    /**
     * Get Orders by User Id
     *
     * @param userId
     * @param pageable
     * @return Orders Set on JSON format
     */
    @GetMapping("report/users/{userId}/orders")
    public Page<OrderDto> getUserOrders(@PathVariable UUID userId, Pageable pageable) {
        return Optional.of(userId)
                .map(it -> orderService.getUserOrders(userId, pageable))
                .map(it -> it.map(orderMapper::toDto))
                .orElseThrow();
    }
}
