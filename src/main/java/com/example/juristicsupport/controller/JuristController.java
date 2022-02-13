package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.dto.JuristCreateDto;
import com.example.juristicsupport.domain.dto.JuristDto;
import com.example.juristicsupport.domain.dto.JuristUpdateDto;
import com.example.juristicsupport.domain.exception.EntityNotFoundException;
import com.example.juristicsupport.domain.mapper.JuristMapper;
import com.example.juristicsupport.service.JuristService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * @author ilyin
 * @since 11.02.2022
 */

@RestController
//path = http://localhost:8080/api/v1.0/jurists
@RequestMapping(path = "jurists")
@RequiredArgsConstructor
public class JuristController {

    private final JuristMapper juristMapper;
    private final JuristService juristService;

    //Get support by SupportID
    @GetMapping("/{Id}")
    public JuristDto get(@PathVariable(name = "Id") UUID id) {
        return Optional.of(id)
                .map(juristService::get)
                .map(juristMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "Jurist"));
    }

    //Add new Support
    @PostMapping
    public JuristDto create(@RequestBody JuristCreateDto createDto) {
        return Optional.ofNullable(createDto)
                .map(juristMapper::fromCreateDto)
                .map(juristService::create)
                .map(juristMapper::toDto)
                .orElseThrow();
    }

    //Update support
    @PatchMapping("/{juristId}")
    public JuristDto update(@PathVariable(name = "juristId") UUID id, @RequestBody JuristUpdateDto updateDto) {
        return Optional.ofNullable(updateDto)
                .map(juristMapper::fromUpdateDto)
                .map(toUpdate -> juristService.update(id, toUpdate))
                .map(juristMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "Jurist"));
    }

    //Delete support
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        juristService.delete(id);
    }
}
