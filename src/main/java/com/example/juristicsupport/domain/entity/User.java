package com.example.juristicsupport.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
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
    String firstName;
    String lastName;
    String email;
}
