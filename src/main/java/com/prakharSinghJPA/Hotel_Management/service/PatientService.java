package com.prakharSinghJPA.Hotel_Management.service;

import com.prakharSinghJPA.Hotel_Management.entity.Patient;
import com.prakharSinghJPA.Hotel_Management.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("ID is not present"));
        return p1;
    }
}
