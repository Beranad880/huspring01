package com.example.humbleshowcase.controllers;

import com.example.humbleshowcase.dto.InsuranceDTO;
import com.example.humbleshowcase.models.Insurance;
import com.example.humbleshowcase.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurances() {
        List<Insurance> insurances = insuranceService.getAllInsurances();
        return new ResponseEntity<>(insurances, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceDTO> getInsuranceById(@PathVariable UUID id) {
        Optional<Insurance> insuranceOptional = insuranceService.getInsuranceById(id);
        return insuranceOptional.map(insurance -> {
            InsuranceDTO dto = new InsuranceDTO();
            dto.setInsuranceNumber(insurance.getInsuranceNumber());
            dto.setInsuranceType(insurance.getInsuranceType());
            dto.setClientId(insurance.getClient().getId()); // Získáme ID klienta
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Insurance> createInsurance(@RequestBody Insurance insurance, @RequestParam UUID clientId) {
        Insurance createdInsurance = insuranceService.createInsurance(insurance, clientId);
        return new ResponseEntity<>(createdInsurance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Insurance> updateInsurance(@PathVariable UUID id, @RequestBody Insurance insurance) {
        Insurance updatedInsurance = insuranceService.updateInsurance(id, insurance);
        if (updatedInsurance != null) {
            return new ResponseEntity<>(updatedInsurance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurance(@PathVariable UUID id) {
        insuranceService.deleteInsurance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}