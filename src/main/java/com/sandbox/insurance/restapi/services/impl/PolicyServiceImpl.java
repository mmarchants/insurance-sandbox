package com.sandbox.insurance.restapi.services.impl;

import com.sandbox.insurance.restapi.entities.PolicyEntity;
import com.sandbox.insurance.restapi.records.Policy;
import com.sandbox.insurance.restapi.repositories.PolicyRepository;
import com.sandbox.insurance.restapi.services.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository repository;

    @Autowired
    public PolicyServiceImpl(PolicyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Policy> getAllPolicies() {
        try {
            return repository.findAll()
                    .stream().map(PolicyEntity::toRecord)
                    .toList();
        } catch (Exception e) {
            log.error("Exception while executing 'getAllPolicies()': ", e);
        }
        return null;
    }

    @Override
    public Policy savePolicy(Policy policy) {
        try {
            return repository.save(policy.toEntity())
                    .toRecord();
        } catch (Exception e) {
            log.error("Exception while executing 'savePolicy({})': ", policy != null ? policy.toString() : null, e);
        }
        return null;
    }

    @Override
    public Policy getPolicyById(Long id) {
        try {
            return repository.findById(id)
                    .map(PolicyEntity::toRecord)
                    .orElse(null);
        } catch (Exception e) {
            log.error("Exception while executing 'getPolicyById({})': ", id, e);
        }
        return null;
    }

    @Override
    public Policy updatePolicyById(Long id, Policy policy) {
        try {
            Optional<Policy> foundPolicy = repository.findById(id).map(PolicyEntity::toRecord);
            if (foundPolicy.isPresent()) {
                Policy updatedPolicy = Policy.builder()
                        .id(foundPolicy.get().id())
                        .name(policy.name())
                        .active(policy.active())
                        .build();
                return repository.save(updatedPolicy.toEntity())
                        .toRecord();
            }
        } catch (Exception e) {
            log.error("Exception while executing 'updatePolicyById({})': ", id, e);
        }
        return null;
    }

    @Override
    public boolean deletePolicyById(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return !repository.existsById(id);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'deletePolicyById({})': ", id, e);
        }
        return false;
    }

}

