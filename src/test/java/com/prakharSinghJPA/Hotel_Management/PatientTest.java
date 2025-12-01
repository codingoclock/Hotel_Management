package com.prakharSinghJPA.Hotel_Management;

import com.prakharSinghJPA.Hotel_Management.dto.GenderCountResponseEntity;
import com.prakharSinghJPA.Hotel_Management.entity.Patient;
import com.prakharSinghJPA.Hotel_Management.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PatientTest {

    @Autowired
    public PatientRepository patientRepository;

    @Test
    public void findPatients(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }
    @Test
    public void testTransactionMethods(){
//        Patient pats = patientRepository.findByNameIgnoreCase("Diya Singh");
//        System.out.println(pats);

          //JPA_Query_Methods
//        List<Patient> patientList = patientRepository.findByDateOrEmail(LocalDate.of(2025,8,12 ), "justbitchin@gmail.com");
//        for(Patient pat :  patientList){
//            System.out.println(pat);
//        }
        //Custom Query for Gender
//        List<Patient> patientList = patientRepository.findByGender("Female");
//        for(Patient pat : patientList){
//            System.out.println(pat);
//        }
        //Custom Query for after the Date
//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1988,8,15));
//        for(Patient pats : patientList){
//            System.out.println(pats);
//        }
        //Object return
//        List<Object []> patientList = patientRepository.countEachGenderType();
//        for(Object[] obj : patientList){
//            System.out.println(obj[0] + " " + obj[1]);
//        }
        //Return 1, if done
//        int patientList = patientRepository.updateNameAndId("Mayank",3);
//        System.out.println(patientList);

//        List<GenderCountResponseEntity> patientList = patientRepository.countEachGenderType();
//        for(GenderCountResponseEntity obj : patientList){
//            System.out.println(obj);
//        }
//
    }
}
