package com.example.juristicsupport.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PRIVATE;

/**
 * Internal data structure(User Order entity)
 *
 * @author ilyin
 * @since 14.01.2022
 */

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "jurist_id")
    Jurist jurist;

    @Setter(PRIVATE)
    @ManyToMany(fetch = EAGER)
    @JoinTable(
            name = "order_support_mtm",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "support_id")
    )
    private Set<Support> supports;

    @Transient
    Set<Integer> supportsId;

    Integer orderPrice;

    public void addSupports(Set<Support> supports) {
        this.supports = supports;
    }
}
