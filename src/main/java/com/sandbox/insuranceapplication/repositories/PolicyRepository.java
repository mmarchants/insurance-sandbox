package com.sandbox.insuranceapplication.repositories;

import com.sandbox.insuranceapplication.repositories.entities.PolicyEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends ListCrudRepository<PolicyEntity, Long> { }
