package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.Jurist;

import java.util.UUID;

public interface JuristService {

    Jurist get(UUID id);

    Jurist create(Jurist jurist);

    Jurist update(UUID id, Jurist jurist);

    void delete(UUID id);

    Jurist getFreeJurist();

}
