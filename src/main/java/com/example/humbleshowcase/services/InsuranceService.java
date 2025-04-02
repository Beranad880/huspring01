package com.example.humbleshowcase.services;

import com.example.humbleshowcase.models.Insurance;
import com.example.humbleshowcase.repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.humbleshowcase.models.Client;
import com.example.humbleshowcase.repositories.ClientRepository;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private ClientRepository clientRepository;

    public List<Insurance> getAllInsurances() {
        return insuranceRepository.findAll();
    }

    public Optional<Insurance> getInsuranceById(UUID id) {
        return insuranceRepository.findById(id);
    }


    public Insurance createInsurance(Insurance insurance, UUID clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + clientId));

        insurance.setClient(client);
        return insuranceRepository.save(insurance);
    }


    public Insurance updateInsurance(UUID id, Insurance insuranceDetails) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow(() -> new RuntimeException("Insurance not found"));
        insurance.setInsuranceType(insuranceDetails.getInsuranceType());
        return insuranceRepository.save(insurance);
    }

    public void deleteInsurance(UUID id) {
        insuranceRepository.deleteById(id);
    }
}
