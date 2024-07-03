package com.sandbox.insuranceapplication.repositories.records;

import com.sandbox.insuranceapplication.repositories.entities.PolicyEntity;
import lombok.Builder;

@Builder
public record Policy(long id, String name, boolean active) {

    public PolicyEntity toEntity() {
        return new PolicyEntity(id, name, active);
    }

}
