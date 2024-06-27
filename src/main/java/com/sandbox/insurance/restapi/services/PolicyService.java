package com.sandbox.insurance.restapi.services;

import com.sandbox.insurance.restapi.records.Policy;

import java.util.List;
import java.util.Optional;

public interface PolicyService {

    List<Policy> getAllPolicies();

    Policy savePolicy(Policy policy);

    Policy getPolicyById(Long id);

    Policy updatePolicyById(Long id, Policy policy);

    boolean deletePolicyById(Long id);

}
