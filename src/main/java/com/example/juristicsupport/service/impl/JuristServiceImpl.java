package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Jurist;
import com.example.juristicsupport.domain.mapper.JuristMapper;
import com.example.juristicsupport.repository.JuristReporsitory;
import com.example.juristicsupport.service.JuristService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
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
public class JuristServiceImpl implements JuristService {

    private final JuristReporsitory juristReporsitory;
    private final JuristMapper juristMapper;

    @Override
    public Jurist get(UUID id) {
        return juristReporsitory.get(id);
    }

    @Override
    public Jurist create(Jurist jurist) {
        return juristReporsitory.create(jurist);
    }

    @Override
    public Jurist update(UUID id, Jurist jurist) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> juristMapper.merge(current, jurist))
                .map(juristReporsitory::update)
                .orElseThrow();
    }

    @Override
    public void delete(UUID id) {
        juristReporsitory.delete(id);
    }

    public Jurist getFreeJurist() {
        Set<Jurist> juristSet = juristReporsitory.getAll();
        // First Jurist from Set (Update later)
        for (Jurist jurist : juristSet) {
            return jurist;
        }
        return null;
    }
}
