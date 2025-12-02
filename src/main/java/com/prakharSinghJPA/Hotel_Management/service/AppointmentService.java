package com.prakharSinghJPA.Hotel_Management.service;


import com.prakharSinghJPA.Hotel_Management.entity.Appointment;
import com.prakharSinghJPA.Hotel_Management.entity.Doctor;
import com.prakharSinghJPA.Hotel_Management.entity.Patient;
import com.prakharSinghJPA.Hotel_Management.repository.AppointmentRepository;
import com.prakharSinghJPA.Hotel_Management.repository.DoctorRepository;
import com.prakharSinghJPA.Hotel_Management.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId)
    {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null){
            throw new IllegalArgumentException("Appointment should not pre-exist");
        }

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

//        patient.getAppointment().add(appointment);  //Just to maintain the Bi-directional mapping.

        Appointment appointment1 = appointmentRepository.save(appointment);

        return(appointment1);
    }

    @Transactional
    public Appointment reAssignAppointment(Long doctorId, Long appointmentId)
    {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        //Now Appointmet is the owning class, here so
        appointment.setDoctor(doctor);
        //After this function, is done it'll check whether the appointment is dirty, if yes, it'll be updated.
        //We should check about bi-directional consistency as well, but we won't need it this time.
        return appointment;

    }
}
