package com.example.humbleshowcase.repositories;

import com.example.humbleshowcase.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}