package com.example.humbleshowcase.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID insuranceNumber;

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
