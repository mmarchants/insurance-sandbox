package com.sandbox.insuranceapplication.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "driver")
public class DriverEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private String driversLicence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id")
    private PolicyEntity policy;
}
