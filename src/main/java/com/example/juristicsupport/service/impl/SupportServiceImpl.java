package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.domain.mapper.SupportMapper;
import com.example.juristicsupport.repository.SupportRepository;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Service to work with Support Types
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

    // Get Support by id
    public Support get(Integer id) {
        return supportRepository.get(id);
    }

    // Add new Support
    public Support create(Support support) {
        return supportRepository.create(support);
    }

    //Update
    public Support update(Integer supportId, Support support) {
        return Optional.of(supportId)
                .map(this::get)
                .map(current -> supportMapper.merge(current, support))
                .map(supportRepository::update)
                .orElseThrow();
    }

    //Delete
    @Override
    public void delete(UUID id) {
        supportRepository.delete(id);
    }


    // Get all Supports(Later)
    /*public Map<Integer, Support> getAll() {
//        return supportRepository.getAll();
        return null;
    }*/
}
