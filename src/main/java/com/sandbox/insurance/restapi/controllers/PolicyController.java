package com.sandbox.insurance.restapi.controllers;

import com.sandbox.insurance.restapi.records.Policy;
import com.sandbox.insurance.restapi.services.PolicyService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PolicyController {

    private final PolicyService service;

    @Autowired
    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @GetMapping("/policies")
    public List<Policy> getPolicies() {
        log.info("GET /policies");
        try {
            List<Policy> policies = service.getAllPolicies();
            log.info("Nº of policies:  {}", policies.size());
            return policies;
        } catch (Exception e) {
            log.error("Exception while executing 'getPolicies()': ", e);
        }
        return null;
    }

    @PostMapping("/policy")
    public Policy savePolicy(@Valid @RequestBody Policy policy) {
        log.info("POST /policy");
        try {
            Policy newPolicy = service.savePolicy(policy);
            if (newPolicy == null) {
                log.info("Policy {} wasn't saved", policy.toString());
            } else {
                log.info("Saved policy: {} (ID {})", newPolicy.name(), newPolicy.id());
            }
            return newPolicy;
        } catch (Exception e) {
            log.error("Exception while executing 'savePolicy({})': ", policy != null ? policy.toString() : null, e);
        }
        return null;
    }

    @GetMapping("/policy/{id}")
    public Policy getPolicyById(@PathVariable("id") String id) {
        log.info("GET /policy/{}", id);
        try {
            Policy foundPolicy = service.getPolicyById(Long.valueOf(id));
            if (foundPolicy == null) {
                log.info("No policy found for ID: {}", id);
            } {
                log.info("Policy found for ID {}: {}", id, foundPolicy.toString());
            }
            return foundPolicy;
        } catch (Exception e) {
            log.error("Exception while executing 'getPolicyById({})", id, e);
        }
        return null;
    }

    @PutMapping("/policy/{id}")
    public Policy updatePolicyById(@PathVariable("id") Long id, @Valid @RequestBody Policy policy) {
        log.info("PUT /policy/{}", id);
        try {
            Policy updatedPolicy = service.updatePolicyById(id, policy);
            if (updatedPolicy == null) {
                log.info("Policy ID {} wasn't found", id);
            } else {
                log.info("Updated policy: {} (ID {})", updatedPolicy.name(), updatedPolicy.id());
            }
            return updatedPolicy;
        } catch (Exception e) {
            log.error("Exception while executing 'updatePolicyById({})': ", id, e);
        }
        return null;
    }

    @DeleteMapping("/policy/{id}")
    public boolean deletePolicyById(@PathVariable Long id) {
        log.info("DELETE /policy/{id}");
        try {
            if (service.deletePolicyById(id)) {
                log.info("Policy with ID {} was deleted", id);
            } else {
                log.info("Policy with ID {} wasn't found/deleted", id);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'deletePolicyById({})': ", id, e);
        }
        return false;
    }
}
