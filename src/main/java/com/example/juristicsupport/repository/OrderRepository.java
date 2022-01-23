package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Order;

import java.util.UUID;

public interface OrderRepository {

    Order get(UUID id);

    Order create(Order user);

}
