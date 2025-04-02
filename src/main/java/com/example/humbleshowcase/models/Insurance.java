package com.example.humbleshowcase.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data // Lombok annotation to generate getter, setter, toString, and other methods automatically
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatically generate UUID for insuranceNumber
    private UUID insuranceNumber; // Changed insuranceNumber type to UUID for better uniqueness

    private String insuranceType;  // Type of insurance

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)  // Foreign key to Client
    private Client client;

    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceNumber=" + insuranceNumber +
                ", insuranceType='" + insuranceType + '\'' +
                ", client=" + (client != null ? client.getId() : "No Client Assigned") +
                '}';
    }
}
