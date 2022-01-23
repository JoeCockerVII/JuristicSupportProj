package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.Support;

import java.util.List;
import java.util.Map;

public interface SupportService {
    Map<Integer, Support> getAll();

    Support get(Integer id);
}
