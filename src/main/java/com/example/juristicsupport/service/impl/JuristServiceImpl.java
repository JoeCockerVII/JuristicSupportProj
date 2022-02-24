package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Jurist;
import com.example.juristicsupport.domain.mapper.JuristMapper;
import com.example.juristicsupport.repository.JuristReporsitory;
import com.example.juristicsupport.service.JuristService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * Service to work with JuristRepository
 *
 * @author ilyin
 * @since 22.01.2022
 */

@Service
@Primary
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JuristServiceImpl implements JuristService {

    private final JuristReporsitory juristReporsitory;
    private final JuristMapper juristMapper;

    @Override
    public Jurist get(UUID id) {
        Jurist result = juristReporsitory.getById(id);
        Hibernate.initialize(result); //for LAZY
        Hibernate.initialize(result.getOrders());//for LAZY
        return result;
    }

    @Override
    @Transactional
    public Jurist create(Jurist jurist) {
        return juristReporsitory.save(jurist);
    }

    @Override
    @Transactional
    public Jurist update(UUID id, Jurist jurist) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> juristMapper.merge(current, jurist))
                .map(juristReporsitory::save)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        juristReporsitory.deleteById(id);
    }

    @Override
    @Transactional
    public Jurist getFreeJurist() {
        Jurist jurist = juristReporsitory.getFirstByBusyStatusEquals(0);
        jurist.setBusyStatus(1);
        juristReporsitory.save(jurist);
        return jurist;
    }
}
