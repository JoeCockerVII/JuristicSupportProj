package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Service Interface to work with OrderRepository
 *
 * @author ilyin
 * @since 20.01.2022
 */
public interface OrderService {
    /**
     * Get order by id (for Report)
     *
     * @param orderId order id
     * @return Order Entity
     */
    Order get(UUID orderId);

    /**
     * Add new order
     *
     * @param order Order
     * @return Order Entity
     */
    Order create(UUID userId, Order order);

    /**
     * Update order by id
     *
     * @param id    of order
     * @param order Order
     * @return Order Entity
     */
    Order update(UUID id, Order order);

    /**
     * Delete order by id
     *
     * @param orderId of order
     */
    void delete(UUID userId, UUID orderId);

    /**
     * Get all orders (for Report)
     *
     * @return Orders Set(Page)
     */
    Page<Order> getAll(Pageable pageable);

    /**
     * Get all User orders (for Report)
     *
     * @param userId
     * @return Orders Set(Page)
     */
    Page<Order> getUserOrders(UUID userId, Pageable pageable);
}
