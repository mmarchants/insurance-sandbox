package com.sandbox.insuranceapplication.controllers;

import com.sandbox.insuranceapplication.repositories.entities.DriverEntity;
import com.sandbox.insuranceapplication.repositories.entities.PolicyEntity;
import com.sandbox.insuranceapplication.repositories.entities.VehicleEntity;
import com.sandbox.insuranceapplication.services.PolicyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PolicyController {

    private final PolicyService service;

    @GetMapping("/policies")
    public Page<PolicyEntity> getAllPolicies(
            @PageableDefault(page = 0, size = 10, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        log.info("GET /policies");
        return service.getAllPolicies(pageable);
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

    @GetMapping("/policy/{name}/drivers")
    public List<DriverEntity> getPolicyDrivers(@PathVariable("name") String name) {
        log.info("GET /policy/{}/drivers", name);
        return service.getPolicyDrivers(name);
    }

    @GetMapping("/policy/{name}/vehicles")
    public List<VehicleEntity> getPolicyVehicles(@PathVariable("name") String name) {
        log.info("GET /policy/{}/vehicles", name);
        return service.getPolicyVehicles(name);
    }
}
