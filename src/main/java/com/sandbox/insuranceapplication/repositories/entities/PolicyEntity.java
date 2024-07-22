package com.sandbox.insuranceapplication.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "policy")
@JsonIgnoreProperties({"hibernateLazyInitializer", "vehicles", "drivers"})
public class PolicyEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean active;

    @ToString.Exclude
    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleEntity> vehicles;

    @ToString.Exclude
    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DriverEntity> drivers;

}
