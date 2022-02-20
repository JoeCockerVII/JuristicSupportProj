package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Order;
import java.util.Set;
import java.util.UUID;

/**
 * OrderRepository Interface
 *
 * @author ilyin
 * @since 20.01.2022
 */

public interface OrderRepository {
    /**
     * Get order by if (for Report)
     *
     * @param id of order
     * @return Order Entity
     */
    Order get(UUID id);

    /**
     * Add new order
     *
     * @param order Order
     * @return Order Entity
     */
    Order create(Order order);

    /**
     * Update order by id
     *
     * @param order Order
     * @return Order Entity
     */
    Order update(Order order);

    /**
     * Delete order by id
     *
     * @param orderId of order
     */
    void delete(UUID orderId);

    /**
     * Get all orders (for Report)
     *
     * @return Orders Set(Page)
     */
    Set<Order> getAll();

    /**
     * Get all User orders (for Report)
     *
     * @param userId
     * @return Orders Set(Page)
     */
    Set<Order> getUserOrders(UUID userId);
}
