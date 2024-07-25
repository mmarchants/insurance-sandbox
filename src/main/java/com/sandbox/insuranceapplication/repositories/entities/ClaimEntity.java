package com.sandbox.insuranceapplication.repositories.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "claim")
public class ClaimEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String identifier;
    private LocalDate claimDate;
    private String description;
    private boolean solved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private DriverEntity driver;

}
