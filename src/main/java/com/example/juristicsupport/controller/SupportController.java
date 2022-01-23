package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Controller to work with Support Types
 *
 * @author ilyin
 * @since 14.01.2022
 */

@RestController
//path = http://localhost:8080/api/v1.0/supports
//@RequestMapping(path = "supports")
@RequiredArgsConstructor
public class SupportController {

    private final SupportService supportService;

    @GetMapping(path = "supports")
    public Map<Integer, Support> get() {
        return supportService.getAll();
    }

}
