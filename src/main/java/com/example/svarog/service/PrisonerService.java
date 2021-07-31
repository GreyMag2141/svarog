package com.example.svarog.service;

import com.example.svarog.entity.Prisoner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PrisonerService {

    UUID CreateOrUpdatePrisoner(Prisoner prisoner);

    Optional<Prisoner> findById(UUID id);

    List<Prisoner> findAll();

    void deleteById(UUID id);
}
