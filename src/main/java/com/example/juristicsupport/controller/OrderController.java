package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.dto.OrderCreateDto;
import com.example.juristicsupport.domain.dto.OrderDto;
import com.example.juristicsupport.domain.mapper.OrderMapper;
import com.example.juristicsupport.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller to work with Order
 *
 * @author ilyin
 * @since 14.01.2022
 */

@RestController
//path = http://localhost:8080/api/v1.0/users/{userId}/orders
@RequestMapping(path = "users")
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;
    private final OrderService orderService;

    @PostMapping("/{userId}/orders")
    public OrderDto create(@PathVariable UUID userId, @RequestBody OrderCreateDto createDto) {

        return Optional.ofNullable(createDto)
                .map(toUpdate -> orderMapper.fromCreateDto(userId, toUpdate))
                .map(orderService::create)
                .map(orderMapper::toDto)
                .orElseThrow();
    }

}
