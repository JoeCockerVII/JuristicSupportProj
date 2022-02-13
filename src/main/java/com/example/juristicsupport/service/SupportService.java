package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.Support;

import java.util.Map;
import java.util.UUID;

public interface SupportService {

    Support get(Integer id);

    Support create(Support support);

    Support update(Integer supportId, Support support);

    void delete(UUID support);

    //Set<Support> getAll(); //later
}
