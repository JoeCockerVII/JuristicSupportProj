package com.example.juristicsupport.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

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

    @Column(columnDefinition = "varchar(36)")
    @Type(type = "uuid-char")
    UUID userId;
/*
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;*/

    @Transient
    Set<Integer> supportsId;
    @Transient
    Set<Support> supports;
    @Transient
    Jurist jurist;

    Integer orderPrice;
}
