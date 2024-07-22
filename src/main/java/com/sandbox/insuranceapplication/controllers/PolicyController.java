package com.sandbox.insuranceapplication.controllers;

import com.sandbox.insuranceapplication.repositories.entities.PolicyEntity;
import com.sandbox.insuranceapplication.services.PolicyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PolicyController {

    private final PolicyService service;

    @GetMapping("/policies")
    public List<PolicyEntity> getAllPolicies() {
        log.info("GET /policies");
        return service.getAllPolicies();
    }

    @PostMapping("/policy")
    public PolicyEntity savePolicy(@Valid @RequestBody PolicyEntity policy) {
        log.info("POST /policy");
        return service.savePolicy(policy);
    }

    @GetMapping("/policy/{id}")
    public PolicyEntity getPolicyById(@PathVariable("id") String id) {
        log.info("GET /policy/{}", id);
        return service.getPolicyById(id);
    }

    @PutMapping("/policy/{id}")
    public PolicyEntity updatePolicyById(@PathVariable("id") String id, @Valid @RequestBody PolicyEntity policy) {
        log.info("PUT /policy/{}", id);
        return service.updatePolicyById(id, policy);
    }

    @DeleteMapping("/policy/{id}")
    public boolean deletePolicyById(@PathVariable String id) {
        log.info("DELETE /policy/{}", id);
        return service.deletePolicyById(id);
    }

    @GetMapping("/policy/{id}/drivers")
    public PolicyEntity getPolicyDrivers(@PathVariable("id") String id) {
        log.info("GET /policy/{}/drivers", id);
        return service.getPolicyById(id);
    }
}
