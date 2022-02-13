package com.example.juristicsupport.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

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

    //    @Generated()
//    @Column(name = "support_id", columnDefinition = "serial", updatable = false)
    Integer supportId;
    String supportName;
    Integer supportPrice;
}
