package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.domain.mapper.OrderMapper;
import com.example.juristicsupport.repository.OrderRepository;
import com.example.juristicsupport.service.JuristService;
import com.example.juristicsupport.service.OrderService;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Service to work with OrderRepository
 *
 * @author ilyin
 * @since 20.01.2022
 */

@Service
@Primary
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final SupportService supportService;
    private final JuristService juristService;

    public Order get(UUID id) {
        Order result = orderRepository.getById(id);
        Hibernate.initialize(result);
        return result;
    }

    @Transactional
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

        return orderRepository.save(order);
    }

    @Transactional
    public Order update(UUID id, Order order) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> orderMapper.merge(current, order))
                .map(orderRepository::save)
                .orElseThrow();
    }

    @Transactional
    public void delete(UUID orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public List<Order> getUserOrders(UUID userId) {
        return orderRepository.findOrderByUserId(userId);
    }
}
