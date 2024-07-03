package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.records.Policy;

import java.util.List;

public interface PolicyService {

    List<Policy> getAllPolicies();

    Policy savePolicy(Policy policy);

    Policy getPolicyById(Long id);

    Policy updatePolicyById(Long id, Policy policy);

    boolean deletePolicyById(Long id);

}
