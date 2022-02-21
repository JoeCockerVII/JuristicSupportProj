package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Support;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * SupportRepository Interface
 *
 * @author ilyin
 * @since 14.01.2022
 */
public interface SupportRepository extends JpaRepository<Support, UUID> {

    /**
     * Get support by supportId (Integer)
     *
     * @param id support id
     * @return Support Entity
     */
    Support getBySupportId(Integer id);
}
