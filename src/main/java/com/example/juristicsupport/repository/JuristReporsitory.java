package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Jurist;

import java.util.Set;
import java.util.UUID;

/**
 * JuristRepository Interface
 *
 * @author ilyin
 * @since 22.01.2022
 */
public interface JuristReporsitory {
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
     * @param jurist Jurist
     * @return Jurist Entity
     */
    Jurist create(Jurist jurist);

    /**
     * Update jurist by id
     *
     * @param jurist Jurist
     * @return Jurist Entity
     */
    Jurist update(Jurist jurist);

    /**
     * Delete jurist by id
     *
     * @param id of jurist
     */
    void delete(UUID id);

    /**
     * Get first free jurist from DB (Rename to getFreeJurist())
     *
     * @return Jurist Entity
     */
    Set<Jurist> getAll();

}
