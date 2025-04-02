package com.example.humbleshowcase.dto;

import java.util.UUID;

public class InsuranceDTO {
    private UUID insuranceNumber;
    private String insuranceType;
    private UUID clientId;

    public UUID getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(UUID insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
}
