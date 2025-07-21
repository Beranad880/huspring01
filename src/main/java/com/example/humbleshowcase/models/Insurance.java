package com.example.humbleshowcase.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // Import validation annotations
import jakarta.validation.constraints.Size;    // Import validation annotations
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Changed to UUID generation for consistency with Client
    private UUID insuranceNumber;

    @NotBlank(message = "Insurance type cannot be blank")
    @Size(min = 3, max = 100, message = "Insurance type must be between 3 and 100 characters")
    private String insuranceType;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
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
