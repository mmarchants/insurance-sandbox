package com.sandbox.insurance.restapi.records;

import com.sandbox.insurance.restapi.entities.PolicyEntity;
import lombok.Builder;

@Builder
public record Policy(long id, String name, boolean active) {

    public PolicyEntity toEntity() {
        return new PolicyEntity(id, name, active);
    }

}
