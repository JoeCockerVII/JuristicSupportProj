package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.repository.OrderRepository;
import com.example.juristicsupport.service.JuristService;
import com.example.juristicsupport.service.OrderService;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    private final SupportService supportService;
    private final JuristService juristService;

    /**
     * Add jurist, supports and price to Order Entity
     *
     * @param order
     * @return Entity of Order
     */
    @Override
    public Order create(Order order) {
        List<Support> supports = new ArrayList<>();
        Integer orderTotalPrice = 0;

        for (Integer id : order.getSupportsId()) {
            supports.add(supportService.get(id));
            orderTotalPrice += supportService.get(id).getSupportPrice();
        }
        order.setSupports(supports);
        order.setOrderPrice(orderTotalPrice);
        order.setJurist(juristService.get());

        return orderRepository.create(order);
    }


    /**
     * Get All Orders
     */
    public Map<UUID, Order> getAll() {
        return orderRepository.getAll();
    }

    /**
     * Get Order by ID
     */
    public Order getOrder(UUID orderId) {
        return orderRepository.getOrder(orderId);
    }

    /**
     * Get User Orders by his ID
     */
    public List<Order> getUserOrders(UUID userId) {
        return orderRepository.getUserOrders(userId);
    }


}
