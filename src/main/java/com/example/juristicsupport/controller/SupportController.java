package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.dto.SupportCreateDto;
import com.example.juristicsupport.domain.dto.SupportDto;
import com.example.juristicsupport.domain.dto.SupportUpdateDto;
import com.example.juristicsupport.domain.exception.EntityNotFoundException;
import com.example.juristicsupport.domain.mapper.SupportMapper;
import com.example.juristicsupport.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller to work with Support Entity
 *
 * @author ilyin
 * @since 14.01.2022
 */

@RestController
@RequestMapping(path = "supports")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')")
public class SupportController {

    private final SupportMapper supportMapper;
    private final SupportService supportService;

    /**
     * Get support by id
     *
     * @param id support id
     * @return SupportDto on JSON format
     */
    @GetMapping("/{supportId}")
//    @PreAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')")
    public SupportDto get(@PathVariable(name = "supportId") Integer id) {
        return Optional.of(id)
                .map(supportService::get)
                .map(supportMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "Support"));
    }

    /**
     * Add new support
     *
     * @param createDto SupportCreateDto
     * @return SupportDto on JSON format
     */
    @PostMapping
//    @PreAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')")
    public SupportDto create(@RequestBody SupportCreateDto createDto) {

        return Optional.ofNullable(createDto)
                .map(supportMapper::fromCreateDto)
                .map(supportService::create)
                .map(supportMapper::toDto)
                .orElseThrow();
    }

    /**
     * Update support by id
     *
     * @param id        of support
     * @param updateDto SupportUpdateDto
     * @return SupportDto on JSON format
     */
    @PatchMapping("/{supportId}")
//    @PreAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')")
    public SupportDto update(@PathVariable(name = "supportId") Integer id, @RequestBody SupportUpdateDto updateDto) {
        return Optional.ofNullable(updateDto)
                .map(supportMapper::fromUpdateDto)
                .map(toUpdate -> supportService.update(id, toUpdate))
                .map(supportMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "Support"));
    }

    /**
     * Delete support
     * @param id of support
     */
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable(name = "id") UUID id) {
        supportService.delete(id);
    }
}
