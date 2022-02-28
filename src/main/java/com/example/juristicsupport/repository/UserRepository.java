package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * UserRepository Interface
 *
 * @author ilyin
 * @since 18.12.2021
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    /**
     * Get user by email
     *
     * @param email
     * @return Orders Set(Page)
     */
    Optional<User> findByEmail(String email);

    /**
     * User existion check by email
     *
     * @param email
     * @return Orders Set(Page)
     */
    boolean existsByEmail(String email);
}
