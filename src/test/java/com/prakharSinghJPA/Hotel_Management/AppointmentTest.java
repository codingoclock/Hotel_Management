package com.prakharSinghJPA.Hotel_Management;


import com.prakharSinghJPA.Hotel_Management.entity.Appointment;
import com.prakharSinghJPA.Hotel_Management.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder().appointment_time(LocalDateTime.of(2025,12,15,12,35,1)).
                reason("Throat issue").
                build();

        var newAppointment = appointmentService.createAppointment(appointment,1L,2L);

        System.out.println(newAppointment);

        var ressignAppointment = appointmentService.reAssignAppointment(3L, newAppointment.getId());

        System.out.println(ressignAppointment);
    }
}
