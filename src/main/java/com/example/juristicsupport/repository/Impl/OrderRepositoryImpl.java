package com.example.juristicsupport.repository.Impl;

import com.example.juristicsupport.domain.entity.Order;
import com.example.juristicsupport.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

/**
 * OrderRepository
 *
 * @author ilyin
 * @since 20.01.2022
 */

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderRepositoryImpl implements OrderRepository {

    private final EntityManager entityManager;

    @Override
    public Order get(UUID id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    @Transactional
    public Order create(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    @Transactional
    public Order update(Order order) {
        return entityManager.merge(order);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Order order = get(id);
        entityManager.remove(order);
    }

    //REPORT PART

    @Override
    @Transactional
    public Set<Order> getAll() {
        TypedQuery<Order> query = entityManager.createQuery("Select o from Order o", Order.class);
        return new HashSet<>(query.getResultList());
    }

    public Set<Order> getUserOrders(UUID userId) {

        Set<Order> orders = getAll();
        orders.removeIf(o -> !(o.getUserId().equals(userId)));
        return orders;

        /*
        Set<Order> orders = getAll();
        orders.forEach(
                (order) -> {
                    if (!order.getUserId().equals(userId)) {
//                        userOrders.add(value);
                        orders.remove(order);
                    }
                }
        );
        return orders;*/
    }


}


