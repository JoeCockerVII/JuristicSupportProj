package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Jurist;

import java.util.Set;
import java.util.UUID;

public interface JuristReporsitory {

    Jurist get(UUID id);

    Jurist create(Jurist user);

    Jurist update(Jurist user);

    void delete(UUID id);

    Set<Jurist> getAll();

}
