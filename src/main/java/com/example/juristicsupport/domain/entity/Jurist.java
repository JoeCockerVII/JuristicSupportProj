package com.example.juristicsupport.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;
import static lombok.AccessLevel.PRIVATE;

/**
 * Internal data structure(Jurist entity)
 *
 * @author ilyin
 * @since 22.01.2022
 */

@Getter
@Setter
@Entity
@Table(name = "jurists")
@AllArgsConstructor
@NoArgsConstructor
public class Jurist extends BaseEntity {
    String firstName;
    String lastName;
    Integer workExperience;
    Integer busyStatus = 0;

    @Setter(PRIVATE)
    @OneToMany(mappedBy = "jurist",
            orphanRemoval = true,
            cascade = {PERSIST, MERGE, DETACH, REFRESH}
    )
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setJurist(this);
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
    }

}
