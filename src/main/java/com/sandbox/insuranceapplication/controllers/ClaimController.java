package com.sandbox.insuranceapplication.controllers;

import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;
import com.sandbox.insuranceapplication.services.ClaimService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClaimController {

    private final ClaimService service;

    @GetMapping("/claims")
    public Page<ClaimEntity> getAllClaims(
            @PageableDefault(page = 0, size = 10, sort = {"driver", "claimDate"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        log.info("GET /claims");
        return service.getAllClaims(pageable);
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
