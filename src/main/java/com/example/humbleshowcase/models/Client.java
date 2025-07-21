package com.example.humbleshowcase.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*; // Import validation annotations
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Generování UUID
    private UUID id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Column(unique = true) // Ensure email is unique in the database
    private String email;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is not valid")
    private String phone;

    @NotBlank(message = "Personal number cannot be blank")
    @Pattern(regexp = "^[0-9]{6}[/][0-9]{4}$", message = "Personal number must be in format XXXXXX/XXXX") // Example format for Czech personal number (rodné číslo)
    @Column(unique = true) // Ensure personal number is unique
    private String personalNumber;

    @NotBlank(message = "Address cannot be blank")
    @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true) // Added orphanRemoval for better cascade management
    private List<Insurance> insurances;
}
