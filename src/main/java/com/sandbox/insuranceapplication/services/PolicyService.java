package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.entities.PolicyEntity;

import java.util.List;

public interface PolicyService {

    List<PolicyEntity> getAllPolicies();

    PolicyEntity savePolicy(PolicyEntity policy);

    PolicyEntity getPolicyById(String id);

    PolicyEntity updatePolicyById(String id, PolicyEntity policy);

    boolean deletePolicyById(String id);

}
