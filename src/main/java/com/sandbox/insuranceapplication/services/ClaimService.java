package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClaimService {

    Page<ClaimEntity> getAllClaims(Pageable pageable);

    ClaimEntity saveClaim(ClaimEntity claim);

    ClaimEntity getClaimById(String id);

    ClaimEntity updateClaimById(String id, ClaimEntity claim);

    boolean deleteClaimById(String id);

}
