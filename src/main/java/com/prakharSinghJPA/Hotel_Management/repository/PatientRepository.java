package com.prakharSinghJPA.Hotel_Management.repository;


import com.prakharSinghJPA.Hotel_Management.dto.GenderCountResponseEntity;
import com.prakharSinghJPA.Hotel_Management.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByNameIgnoreCase(String name);
    List<Patient> findByDateOrEmail(LocalDate birthdate, String email);

    @Query("SELECT p FROM Patient p WHERE p.gender = ?1")
    List<Patient> findByGender(@Param("gender") String gender);

    @Query("SELECT p FROM Patient p WHERE p.date > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate")LocalDate date);

//    @Query("SELECT p.gender, Count(p) FROM Patient p GROUP BY p.gender")
//    List<Object []> countEachGenderType();

    //Projection Model
//    @Query("SELECT new com.prakharSinghJPA.Hotel_Management.dto.GenderCountResponseEntity(p.gender, Count(p)) FROM PATIENT p GROUP BY p.gender")
//    List<GenderCountResponseEntity> countEachGenderType();

//    @Query(value = "SELECT * FROM PATIENT", nativeQuery = true)
//    List<Patient> findAllPatients();

//    @Transactional
//    @Modifying
//    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
//    int updateNameAndId(@Param("name") String name, @Param("id") int id);
}
