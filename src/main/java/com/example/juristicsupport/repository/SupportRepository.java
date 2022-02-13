package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Support;

import javax.persistence.Query;
import java.util.UUID;

public interface SupportRepository {

    Support get(Integer id);

    Support create(Support support);

    Support update(Support support);

    void delete(UUID id);

    // get all supports (later)
    //Map<Integer, Support> getAll();

}
