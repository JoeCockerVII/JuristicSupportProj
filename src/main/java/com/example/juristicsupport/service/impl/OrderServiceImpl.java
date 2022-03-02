package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Jurist;
import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.domain.mapper.OrderMapper;
import com.example.juristicsupport.repository.OrderRepository;
import com.example.juristicsupport.service.JuristService;
import com.example.juristicsupport.service.OrderService;
import com.example.juristicsupport.service.SupportService;
import com.example.juristicsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final SupportService supportService;
    private final JuristService juristService;
    private final UserService userService;

    public Order get(UUID id) {
        Order result = orderRepository.getById(id);
        Hibernate.initialize(result); //for LAZY
        Hibernate.initialize(result.getUser());//for LAZY
        return result;
    }

    @Transactional
    public Order create(UUID userId, Order order) {
        final User user = userService.get(userId);
        user.addOrder(order);

        final Jurist jurist = juristService.getFreeJurist();
        jurist.addOrder(order);

        Set<Support> supports = supportService.getSupportSetById(order.getSupportsId());
        order.setOrderPrice(supports.stream().mapToInt(Support::getSupportPrice).sum());
        order.addSupports(supports);

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
    public void delete(UUID userId, UUID orderId) {
        final Order toDelete = orderRepository.findById(orderId).orElseThrow();
        UUID juristId = toDelete.getJurist().getId();
        juristService.juristBysyStatusSet(juristId, 0);
        userService.get(userId).removeOrder(toDelete);
        juristService.get(juristId).removeOrder(toDelete);
    }

    public Page<Order> getAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Page<Order> getUserOrders(UUID userId, Pageable pageable) {
        return orderRepository.findOrderByUserId(userId, pageable);
    }
}
