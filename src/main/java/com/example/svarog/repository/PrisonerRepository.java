package com.example.svarog.repository;

import com.example.svarog.entity.Prisoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
public interface PrisonerRepository extends JpaRepository<Prisoner, UUID> {
}
