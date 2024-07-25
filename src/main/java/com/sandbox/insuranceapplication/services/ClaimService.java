package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;

import java.util.List;

public interface ClaimService {

    List<ClaimEntity> getAllClaims();

    ClaimEntity saveClaim(ClaimEntity claim);

    ClaimEntity getClaimById(String id);

    ClaimEntity updateClaimById(String id, ClaimEntity claim);

    boolean deleteClaimById(String id);

}
