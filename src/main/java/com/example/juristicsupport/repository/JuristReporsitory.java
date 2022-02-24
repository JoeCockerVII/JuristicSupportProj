package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Jurist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * JuristRepository Interface
 *
 * @author ilyin
 * @since 22.01.2022
 */
public interface JuristReporsitory extends JpaRepository<Jurist, UUID> {

    /**
     * Get first free jurist from DB
     *
     * @param busyStatus
     * @return Jurist Entity
     */
    Jurist getFirstByBusyStatusEquals(Integer busyStatus);

}
