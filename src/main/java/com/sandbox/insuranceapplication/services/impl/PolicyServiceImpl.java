package com.sandbox.insuranceapplication.services.impl;

import com.sandbox.insuranceapplication.repositories.entities.DriverEntity;
import com.sandbox.insuranceapplication.repositories.entities.PolicyEntity;
import com.sandbox.insuranceapplication.repositories.PolicyRepository;
import com.sandbox.insuranceapplication.services.PolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository repository;

    @Override
    public List<PolicyEntity> getAllPolicies() {
        try {
            List<PolicyEntity> policies = repository.findAll();
            log.info("Nº of policies: {}", policies.size());
            return policies;
        } catch (Exception e) {
            log.error("Exception while executing 'getAllPolicies()': ", e);
        }
        return null;
    }

    @Override
    public PolicyEntity savePolicy(PolicyEntity policy) {
        try {
            PolicyEntity newPolicy = repository.save(policy);
            if (repository.existsById(newPolicy.getId())) {
                log.info("Saved policy: {}", newPolicy);
                return newPolicy;
            } else {
                log.info("Policy {} wasn't saved", policy);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'savePolicy({})': ", policy != null ? policy.toString() : null, e);
        }
        return null;
    }

    @Override
    public PolicyEntity getPolicyById(String id) {
        try {
            PolicyEntity foundPolicy = repository.findById(Long.valueOf(id)).orElse(null);
            if (foundPolicy == null) {
                log.info("No policy found with ID: {}", id);
            } else {
                log.info("Policy found with ID {}: {}", id, foundPolicy);
                return foundPolicy;
            }
        } catch (Exception e) {
            log.error("Exception while executing 'getPolicyById({})': ", id, e);
        }
        return null;
    }

    @Override
    public PolicyEntity updatePolicyById(String id, PolicyEntity policy) {
        try {
            PolicyEntity foundPolicy = this.getPolicyById(id);
            if (foundPolicy != null) {
                PolicyEntity updatedPolicy = PolicyEntity.builder()
                        .id(foundPolicy.getId())
                        .name(policy.getName())
                        .active(policy.isActive())
                        .build();
                return this.savePolicy(updatedPolicy);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'updatePolicyById({}, {})': ", id, policy.toString(), e);
        }
        return null;
    }

    @Override
    public boolean deletePolicyById(String id) {
        try {
            Long idNumber = Long.valueOf(id);
            if (repository.existsById(idNumber)) {
                repository.deleteById(idNumber);
                if (repository.existsById(idNumber)) {
                    log.info("Policy with ID {} wasn't deleted", id);
                } else {
                    log.info("Policy with ID {} was deleted", id);
                    return true;
                }
            } else {
                log.info("Policy with ID {} wasn't found", id);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'deletePolicyById({})': ", id, e);
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DriverEntity> getPolicyDrivers(String policyName) {
        try {
            PolicyEntity foundPolicy = repository.findByPolicyName(policyName);
            if (foundPolicy == null) {
                log.info("No policy found with name: {}", policyName);
            } else {
                log.info("Policy found with name {}: {}", policyName, foundPolicy);
                return foundPolicy.getDrivers();
            }
        } catch (Exception e) {
            log.error("Exception while executing 'getPolicyDrivers({})': ", policyName, e);
        }
        return null;
    }
}

