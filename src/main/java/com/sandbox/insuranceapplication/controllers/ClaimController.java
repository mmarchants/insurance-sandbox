package com.sandbox.insuranceapplication.controllers;

import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;
import com.sandbox.insuranceapplication.services.ClaimService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClaimController {

    private final ClaimService service;

    @GetMapping("/claims")
    public List<ClaimEntity> getAllClaims() {
        log.info("GET /claims");
        return service.getAllClaims();
    }

    @PostMapping("/claim")
    public ClaimEntity saveClaim(@Valid @RequestBody ClaimEntity claim) {
        log.info("POST /claim");
        return service.saveClaim(claim);
    }

    @GetMapping("/claim/{id}")
    public ClaimEntity getClaimById(@PathVariable("id") String id) {
        log.info("GET /claim/{}", id);
        return service.getClaimById(id);
    }

    @PutMapping("/claim/{id}")
    public ClaimEntity updateClaimById(@PathVariable("id") String id, @Valid @RequestBody ClaimEntity claim) {
        log.info("PUT /claim/{}", id);
        return service.updateClaimById(id, claim);
    }

    @DeleteMapping("/claim/{id}")
    public boolean deleteClaimById(@PathVariable String id) {
        log.info("DELETE /claim/{}", id);
        return service.deleteClaimById(id);
    }

}
