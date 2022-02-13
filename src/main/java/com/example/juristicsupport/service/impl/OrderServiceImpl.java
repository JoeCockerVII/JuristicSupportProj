package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.domain.mapper.OrderMapper;
import com.example.juristicsupport.repository.OrderRepository;
import com.example.juristicsupport.service.JuristService;
import com.example.juristicsupport.service.OrderService;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service to work with Order
 *
 * @author ilyin
 * @since 20.01.2022
 */

@Service
@Primary
@RequiredArgsConstructor

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final SupportService supportService;
    private final JuristService juristService;

    /**
     * Get Order by ID
     */
    public Order get(UUID orderId) {
        return orderRepository.get(orderId);
    }

    /**
     * Add jurist, supports and price to Order Entity
     *
     * @param order
     * @return Entity of Order
     */
    @Override
    public Order create(Order order) {
        Set<Support> supports = new HashSet<>();
        Integer orderTotalPrice = 0;

        for (Integer id : order.getSupportsId()) {
            supports.add(supportService.get(id));
            orderTotalPrice += supportService.get(id).getSupportPrice();
        }
        order.setSupports(supports);
        order.setOrderPrice(orderTotalPrice);

        // First free Jurist
        order.setJurist(juristService.getFreeJurist());

        return orderRepository.create(order);
    }


    @Override
    public Order update(UUID id, Order order) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> orderMapper.merge(current, order))
                .map(orderRepository::update)
                .orElseThrow();
    }

    @Override
    public void delete(UUID orderId) {
        orderRepository.delete(orderId);
    }

    /**
     * Get All Orders
     *
     * @return
     */
    public Set<Order> getAll() {
        return orderRepository.getAll();
    }

    /**
     * Get User Orders by his ID
     */
    public Set<Order> getUserOrders(UUID userId) {
        return orderRepository.getUserOrders(userId);
    }


}
