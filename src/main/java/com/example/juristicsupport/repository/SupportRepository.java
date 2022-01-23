package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.Support;

import java.util.List;
import java.util.Map;

public interface SupportRepository {

    Map<Integer, Support> getAll();

    Support get(Integer id);
}
