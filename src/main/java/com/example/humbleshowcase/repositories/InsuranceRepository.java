package com.example.humbleshowcase.repositories;

import com.example.humbleshowcase.models.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {
}
