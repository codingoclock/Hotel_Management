package com.prakharSinghJPA.Hotel_Management.repository;

import com.prakharSinghJPA.Hotel_Management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}