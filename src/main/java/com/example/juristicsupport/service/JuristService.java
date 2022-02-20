package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.Jurist;

import java.util.UUID;

/**
 * Service to work with JuristRepository
 *
 * @author ilyin
 * @since 22.01.2022
 */
public interface JuristService {
    /**
     * Get user by user id
     *
     * @param id user id
     * @return Jurist Entity
     */
    Jurist get(UUID id);

    /**
     * Add new jurist
     *
     * @param jurist User
     * @return Jurist Entity
     */
    Jurist create(Jurist jurist);

    /**
     * Update jurist by id
     *
     * @param id     of jurist
     * @param jurist User
     * @return Jurist Entity
     */
    Jurist update(UUID id, Jurist jurist);

    /**
     * Delete jurist by id
     *
     * @param id of jurist
     */
    void delete(UUID id);

    /**
     * Get first free jurist from DB
     *
     * @return Jurist Entity
     */
    Jurist getFreeJurist();
}
