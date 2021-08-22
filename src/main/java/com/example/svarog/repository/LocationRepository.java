package com.example.svarog.repository;

import com.example.svarog.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository  extends JpaRepository<Location, UUID> {
}
