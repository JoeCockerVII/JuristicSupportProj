package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.repository.SupportRepository;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    /**
     * Get All Supports
     */
    public Map<Integer, Support> getAll() {
        return supportRepository.getAll();
    }

    /**
     * Get Support by id
     *
     * @param id
     * @return Support Entity
     */
    public Support get(Integer id) {
        return supportRepository.get(id);
    }

}
