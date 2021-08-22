package com.example.svarog.controllers;

import com.example.svarog.entity.Prisoner;
import com.example.svarog.service.PrisonerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("prisoner")
@Api(tags = "PrisonerController", description = "API for svarog")
public class PrisonerController {

    private final PrisonerService prisonerService;

    @GetMapping
    public List<Prisoner> list() {
        return prisonerService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Prisoner> getById(@PathVariable UUID id) {
        return prisonerService.findById(id);
    }

    @PostMapping
    public UUID createOrUpdate(@RequestBody Prisoner prisoner) {
        return prisonerService.CreateOrUpdatePrisoner(prisoner);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        prisonerService.deleteById(id);
    }
}
