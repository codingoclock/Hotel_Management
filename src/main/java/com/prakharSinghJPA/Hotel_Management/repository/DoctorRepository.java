package com.prakharSinghJPA.Hotel_Management.repository;

import com.prakharSinghJPA.Hotel_Management.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}