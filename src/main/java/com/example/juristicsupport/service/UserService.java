package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.User;

import java.util.UUID;
/**
 * Service Interface to work with UserRepository
 *
 * @author ilyin
 * @since 18.12.2021
 */

public interface UserService {
    /**
     * Get user by user id
     *
     * @param id user id
     * @return User Entity
     */
    User get(UUID id);

    /**
     * Add new user
     *
     * @param user User
     * @return User Entity
     */
    User create(User user);

    /**
     * Update user by id
     *
     * @param id   of user
     * @param user User
     * @return User Entity
     */
    User update(UUID id, User user);

    /**
     * Delete user by id
     *
     * @param id of user
     */
    void delete(UUID id);
}
