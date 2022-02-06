package com.example.juristicsupport.repository.Impl;

import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.repository.OrderRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.util.UUID.randomUUID;

/**
 * Repository to work with User Orders
 *
 * @author ilyin
 * @since 20.01.2022
 */

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final ObjectMapper objectMapper;
    private final File file;
    private final Path path;

    @SneakyThrows
    public OrderRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        path = Path.of("F:/Dropbox/prog/orion/PetProjects/JuristicSupport/ordersDB.json");
        if (!Files.exists(path)) {
            Files.createFile(path);
            Files.writeString(path, "{}");
        }
        this.file = new File(path.toUri());
    }

    public Map<UUID, Order> getAll() {
        return findAll();
    }

    public Order getOrder(UUID orderId) {
        return findAll().get(orderId);
    }

    public List<Order> getUserOrders(UUID userId) {
        List<Order> userOrders = new ArrayList<>();
        Map<UUID, Order> orders = findAll();

        orders.forEach(
                (key, value) -> {
                    if (value.getUserId().equals(userId)) {
                        userOrders.add(value);
                    }
                }
        );
        return userOrders;
    }


    /*
    public Order get(UUID id) {
        return findAll().get(id);
    }*/


    @SneakyThrows
    public Order create(Order order) {
        Map<UUID, Order> content = findAll();
        UUID id = randomUUID();
        order.setOrderId(id);
        content.put(id, order);
        Files.writeString(path, objectMapper.writeValueAsString(content));
        return findAll().get(id);
    }

    @SneakyThrows
    private Map<UUID, Order> findAll() {
        return objectMapper.readValue(file, new TypeReference<>() {
        });
    }


}
