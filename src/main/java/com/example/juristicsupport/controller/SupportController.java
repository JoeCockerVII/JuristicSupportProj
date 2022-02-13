package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.dto.SupportCreateDto;
import com.example.juristicsupport.domain.dto.SupportDto;
import com.example.juristicsupport.domain.dto.SupportUpdateDto;
import com.example.juristicsupport.domain.exception.EntityNotFoundException;
import com.example.juristicsupport.domain.mapper.SupportMapper;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller to work with Support Types
 *
 * @author ilyin
 * @since 14.01.2022
 */

@RestController
//path = http://localhost:8080/api/v1.0/supports
@RequestMapping(path = "supports")
@RequiredArgsConstructor
public class SupportController {

    private final SupportMapper supportMapper;
    private final SupportService supportService;


    //Get support by SupportID
    @GetMapping("/{supportId}")
    public SupportDto get(@PathVariable(name = "supportId") Integer id) {
        return Optional.of(id)
                .map(supportService::get)
                .map(supportMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "Support"));
    }

    //Add new Support
    @PostMapping
    public SupportDto create(@RequestBody SupportCreateDto createDto) {

        return Optional.ofNullable(createDto)
                .map(supportMapper::fromCreateDto)
                .map(supportService::create)
                .map(supportMapper::toDto)
                .orElseThrow();
    }

    //Update support
    @PatchMapping("/{supportId}")
    public SupportDto update(@PathVariable(name = "supportId") Integer id, @RequestBody SupportUpdateDto updateDto) {
        return Optional.ofNullable(updateDto)
                .map(supportMapper::fromUpdateDto)
                .map(toUpdate -> supportService.update(id, toUpdate))
                .map(supportMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "Support"));
    }

    //Delete support
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        supportService.delete(id);
    }


    //Get all Support
    /*@GetMapping
    public Map<Integer, Support> get() {
        return supportService.getAll();
    }*/

}
