package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.entities.DriverEntity;
import com.sandbox.insuranceapplication.repositories.entities.PolicyEntity;
import com.sandbox.insuranceapplication.repositories.entities.VehicleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PolicyService {

    Page<PolicyEntity> getAllPolicies(Pageable pageable);

    PolicyEntity savePolicy(PolicyEntity policy);

    PolicyEntity getPolicyById(String id);

    PolicyEntity updatePolicyById(String id, PolicyEntity policy);

    boolean deletePolicyById(String id);

    List<DriverEntity> getPolicyDrivers(String policyName);

    List<VehicleEntity> getPolicyVehicles(String policyName);

}
