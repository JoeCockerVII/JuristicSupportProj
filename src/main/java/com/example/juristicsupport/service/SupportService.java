package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.Support;

import java.util.UUID;

/**
 * Service Interface to work with SupportRepository
 *
 * @author ilyin
 * @since 14.01.2022
 */

public interface SupportService {
    /**
     * Get support by support id
     *
     * @param id support id
     * @return Support Entity
     */
    Support get(Integer id);

    /**
     * Add new support
     *
     * @param support Support
     * @return Support Entity
     */
    Support create(Support support);

    /**
     * Update support by id
     *
     * @param supportId of support
     * @param support   User
     * @return User Entity
     */
    Support update(Integer supportId, Support support);

    /**
     * Delete support by id
     *
     * @param id of support
     */
    void delete(UUID id);
}
