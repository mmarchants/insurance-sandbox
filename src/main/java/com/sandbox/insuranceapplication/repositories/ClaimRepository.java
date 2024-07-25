package com.sandbox.insuranceapplication.repositories;

import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends ListCrudRepository<ClaimEntity, Long> { }
