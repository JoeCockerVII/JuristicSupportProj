package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.Jurist;
import com.example.juristicsupport.repository.JuristReporsitory;
import com.example.juristicsupport.service.JuristService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Service to work with Jurist
 *
 * @author ilyin
 * @since 22.01.2022
 */

@Service
@Primary
@RequiredArgsConstructor
public class JuristServiceImpl implements JuristService {
    private final JuristReporsitory juristReporsitory;

    public Jurist get() {
        return juristReporsitory.get();
    }
}
