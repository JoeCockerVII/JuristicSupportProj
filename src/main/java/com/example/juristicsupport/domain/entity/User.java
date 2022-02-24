package com.example.juristicsupport.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static lombok.AccessLevel.PRIVATE;

/**
 * Internal data structure (User data)
 *
 * @author ilyin
 * @since 18.12.2021
 */

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;

    @Setter(PRIVATE)
    @OneToMany(mappedBy = "user",
            orphanRemoval = true,
            cascade = {PERSIST, MERGE, DETACH, REFRESH}
    )
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this);
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
    }

}
