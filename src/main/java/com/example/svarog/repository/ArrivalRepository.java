package com.example.svarog.repository;

import com.example.svarog.entity.Arrival;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArrivalRepository extends JpaRepository<Arrival, UUID> {
}

