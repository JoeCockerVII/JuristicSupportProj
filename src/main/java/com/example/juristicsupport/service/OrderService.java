package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.Order;
import org.springframework.data.domain.Page;

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
     * Get order by if (for Report)
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
    Order create(Order order);

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
    void delete(UUID orderId);

    /**
     * Get all orders (for Report)
     *
     * @return Orders Set(Page)
     */
    List<Order> getAll();

    /**
     * Get all User orders (for Report)
     *
     * @param userId
     * @return Orders Set(Page)
     */
    List<Order> getUserOrders(UUID userId);
}
