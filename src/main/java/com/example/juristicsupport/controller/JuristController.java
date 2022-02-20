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
 * Controller to work with Jurist Entity
 *
 * @author ilyin
 * @since 11.02.2022
 */

@RestController
@RequestMapping(path = "jurists")
@RequiredArgsConstructor
public class JuristController {

    private final JuristMapper juristMapper;
    private final JuristService juristService;

    /**
     * Get jurist by id
     *
     * @param id jurist id
     * @return JuristDto on JSON format
     */
    @GetMapping("/{Id}")
    public JuristDto get(@PathVariable(name = "Id") UUID id) {
        return Optional.of(id)
                .map(juristService::get)
                .map(juristMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "Jurist"));
    }

    /**
     * Add new jurist
     *
     * @param createDto JuristCreateDto
     * @return JuristDto on JSON format
     */
    @PostMapping
    public JuristDto create(@RequestBody JuristCreateDto createDto) {
        return Optional.ofNullable(createDto)
                .map(juristMapper::fromCreateDto)
                .map(juristService::create)
                .map(juristMapper::toDto)
                .orElseThrow();
    }

    /**
     * Update jurist by id
     *
     * @param id        of jurist
     * @param updateDto JuristUpdateDto
     * @return JuristDto on JSON format
     */
    @PatchMapping("/{juristId}")
    public JuristDto update(@PathVariable(name = "juristId") UUID id, @RequestBody JuristUpdateDto updateDto) {
        return Optional.ofNullable(updateDto)
                .map(juristMapper::fromUpdateDto)
                .map(toUpdate -> juristService.update(id, toUpdate))
                .map(juristMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "Jurist"));
    }

    /**
     * Delete jurist
     *
     * @param id of jurist
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        juristService.delete(id);
    }
}
