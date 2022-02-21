package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * OrderRepository Interface
 *
 * @author ilyin
 * @since 20.01.2022
 */

public interface OrderRepository extends JpaRepository<Order, UUID> {

    /**
     * Get all orders (for Report)!!!Modify!!!
     *
     * @return Orders Set(Page)
     */
    List<Order> findAll();

    /**
     * Get all User orders (for Report) !!!Modify!!!
     *
     * @param userId
     * @return Orders Set(Page)
     */
    List<Order> findOrderByUserId(UUID userId);

}
