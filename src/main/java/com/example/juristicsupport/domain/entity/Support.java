package com.example.juristicsupport.domain.entity;

import lombok.*;

import javax.persistence.*;

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
}
