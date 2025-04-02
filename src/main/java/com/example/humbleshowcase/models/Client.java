package com.example.humbleshowcase.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Generování UUID
    private UUID id;

    private String name;
    private String email;
    private String phone;
    private String personalNumber;  // Rodné číslo
    private String address;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Insurance> insurances;

    // Konstruktor bez parametrů (nutný pro JPA)
    public Client() {}

    // Konstruktor se všemi parametry
    public Client(UUID id, String name, String email, String phone, String personalNumber, String address, List<Insurance> insurances) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.personalNumber = personalNumber;
        this.address = address;
        this.insurances = insurances;
    }

    // Gettery a Settery
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    // toString metoda
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
