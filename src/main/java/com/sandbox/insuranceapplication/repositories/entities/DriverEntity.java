package com.sandbox.insuranceapplication.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "driver")
@JsonIgnoreProperties({"hibernateLazyInitializer", "claims"})
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

    @ToString.Exclude
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClaimEntity> claims;

}
