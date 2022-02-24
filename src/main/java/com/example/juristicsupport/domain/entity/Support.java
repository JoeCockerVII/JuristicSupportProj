package com.example.juristicsupport.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Internal data structure(Support entity)
 *
 * @author ilyin
 * @since 14.01.2022
 */

@Getter
@Setter
@Entity
@Table(name = "supports")
public class Support extends BaseEntity {
    Integer supportId;
    String supportName;
    Integer supportPrice;

    @ManyToMany(mappedBy = "supports")
    private Set<Order> orders;
}
