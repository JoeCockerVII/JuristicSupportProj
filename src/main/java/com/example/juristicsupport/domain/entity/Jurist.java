package com.example.juristicsupport.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

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
}
