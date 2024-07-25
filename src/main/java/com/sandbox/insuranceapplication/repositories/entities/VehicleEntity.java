package com.sandbox.insuranceapplication.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String vin;
    private String make; // TODO: Make it Enum
    private String model;
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id")
    private PolicyEntity policy;

}
