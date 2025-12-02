package com.prakharSinghJPA.Hotel_Management.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(
        name = "Patient",
        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_email", columnNames = {"email"}), Done by Unique Constraint
                @UniqueConstraint(name = "unique_birth_email", columnNames = {"date","email"}),
//                @UniqueConstraint(name = "unique_ins_id", columnNames = {"insurance_id"})
        },
        indexes = {
                @Index(name = "idx_pat_birth", columnList = "date"),
                @Index(name = "email_idx", columnList = "email")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pat_name", nullable = false, length = 40)
    private String name;

    @Column(nullable = false)
    private LocalDate date;

//    @ToString.Exclude
    private String gender;

    @Column(unique = true, length = 100)
    private String email;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id") //owning side for insurance.
    private Insurance insurance;

    //To make it a bi-directional mapping wrt appointment;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) //reverse Side for the Appointment
    @ToString.Exclude   //LAZY BY DEFAULT IN JPA, to exclude it
    private List<Appointment> appointment;

}
