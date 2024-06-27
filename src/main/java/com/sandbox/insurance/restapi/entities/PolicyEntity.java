package com.sandbox.insurance.restapi.entities;

import com.sandbox.insurance.restapi.records.Policy;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean active;

    public Policy toRecord() {
        return new Policy(id, name, active);
    }
}
