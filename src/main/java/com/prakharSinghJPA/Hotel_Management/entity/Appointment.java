package com.prakharSinghJPA.Hotel_Management.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointment_time;

    @Column(length = 50)
    private String reason;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(nullable = false, name = "patient_id") //patient is required and not nullable
    private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
