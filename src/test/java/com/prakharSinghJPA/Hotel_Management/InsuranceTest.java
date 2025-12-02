package com.prakharSinghJPA.Hotel_Management;

import com.prakharSinghJPA.Hotel_Management.entity.Insurance;
import com.prakharSinghJPA.Hotel_Management.entity.Patient;
import com.prakharSinghJPA.Hotel_Management.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {


    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_123")
                .provider("HDFC_BANK")
                .validUntil(LocalDate.of(2030,9,17)).build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 2L);

        var newInsurance = insuranceService.disassociateInsuranceFromPatient(patient.getId());

    }



}
