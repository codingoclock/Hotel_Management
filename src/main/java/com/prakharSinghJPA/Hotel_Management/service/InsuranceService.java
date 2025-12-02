package com.prakharSinghJPA.Hotel_Management.service;

import com.prakharSinghJPA.Hotel_Management.entity.Insurance;
import com.prakharSinghJPA.Hotel_Management.entity.Patient;
import com.prakharSinghJPA.Hotel_Management.repository.InsuranceRepository;
import com.prakharSinghJPA.Hotel_Management.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional  //Cascading
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found" + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);  //This is done for Bi-directional consistency.

        //Can also return by changing the method header/return type.
        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId)
    {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Not found the patient with" + patientId));
        //Always check, who owns Patient to Insurance Relationship

        patient.setInsurance(null);

        return patient;
    }
}
