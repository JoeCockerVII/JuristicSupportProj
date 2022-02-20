package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.domain.mapper.SupportMapper;
import com.example.juristicsupport.repository.SupportRepository;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

/**
 * Service to work with SupportRepository
 *
 * @author ilyin
 * @since 14.01.2022
 */

@Service
@Primary
@RequiredArgsConstructor

public class SupportServiceImpl implements SupportService {

    private final SupportRepository supportRepository;
    private final SupportMapper supportMapper;

    public Support get(Integer id) {
        return supportRepository.get(id);
    }

    public Support create(Support support) {
        return supportRepository.create(support);
    }

    public Support update(Integer supportId, Support support) {
        return Optional.of(supportId)
                .map(this::get)
                .map(current -> supportMapper.merge(current, support))
                .map(supportRepository::update)
                .orElseThrow();
    }

    @Override
    public void delete(UUID id) {
        supportRepository.delete(id);
    }
}
