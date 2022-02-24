package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.domain.mapper.SupportMapper;
import com.example.juristicsupport.repository.SupportRepository;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
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
@Transactional(readOnly = true)
public class SupportServiceImpl implements SupportService {

    private final SupportRepository supportRepository;
    private final SupportMapper supportMapper;

    @Override
    public Support get(Integer id) {
        return supportRepository.getBySupportId(id);
    }

    @Override
    @Transactional
    public Support create(Support support) {
        return supportRepository.save(support);
    }

    @Override
    @Transactional
    public Support update(Integer supportId, Support support) {
        return Optional.of(supportId)
                .map(this::get)
                .map(current -> supportMapper.merge(current, support))
                .map(supportRepository::save)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        supportRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Set<Support> getSupportSetById(Set<Integer> supportIds) {
        return supportRepository.findBySupportIdIn(supportIds);
    }

}
