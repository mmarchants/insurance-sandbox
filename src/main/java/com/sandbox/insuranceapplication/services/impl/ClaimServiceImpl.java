package com.sandbox.insuranceapplication.services.impl;

import com.sandbox.insuranceapplication.repositories.ClaimRepository;
import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;
import com.sandbox.insuranceapplication.services.ClaimService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository repository;

    @Override
    public List<ClaimEntity> getAllClaims() {
        try {
            List<ClaimEntity> claims = repository.findAll();
            log.info("Nº of claims: {}", claims.size());
            return claims;
        } catch (Exception e) {
            log.error("Exception while executing 'getAllClaims()': ", e);
        }
        return null;
    }

    @Override
    public ClaimEntity saveClaim(ClaimEntity claim) {
        try {
            ClaimEntity newClaim = repository.save(claim);
            if (repository.existsById(claim.getId())) {
                log.info("Saved claim: {}", newClaim);
                return newClaim;
            } else {
                log.info("Claim {} wasn't saved", claim);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'saveClaim({})': ", claim != null ? claim.toString() : null, e);
        }
        return null;
    }

    @Override
    public ClaimEntity getClaimById(String id) {
        try {
            ClaimEntity foundClaim = repository.findById(Long.valueOf(id)).orElse(null);
            if (foundClaim == null) {
                log.info("No claim found with ID: {}", id);
            } else {
                log.info("Claim found with ID {}: {}", id, foundClaim);
                return foundClaim;
            }
        } catch (Exception e) {
            log.error("Exception while executing 'getClaimById({})': ", id, e);
        }
        return null;
    }

    @Override
    public ClaimEntity updateClaimById(String id, ClaimEntity claim) {
        try {
            ClaimEntity foundClaim = this.getClaimById(id);
            if (foundClaim != null) {
                ClaimEntity updatedClaim = ClaimEntity.builder()
                        .id(foundClaim.getId())
                        .identifier(claim.getIdentifier())
                        .claimDate(claim.getClaimDate())
                        .description(claim.getDescription())
                        .solved(claim.isSolved())
                        .driver(claim.getDriver())
                        .build();
                return this.saveClaim(updatedClaim);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'updateClaimById({}, {})': ", id, claim.toString(), e);
        }
        return null;
    }

    @Override
    public boolean deleteClaimById(String id) {
        try {
            Long idNumber = Long.valueOf(id);
            if (repository.existsById(idNumber)) {
                repository.deleteById(idNumber);
                if (repository.existsById(idNumber)) {
                    log.info("Claim with ID {} wasn't deleted", id);
                } else {
                    log.info("Claim with ID {} was deleted", id);
                    return true;
                }
            } else {
                log.info("Claim with ID {} wasn't found", id);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'deleteClaimById({})': ", id, e);
        }
        return false;
    }

}
