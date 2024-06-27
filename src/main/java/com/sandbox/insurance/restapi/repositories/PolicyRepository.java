package com.sandbox.insurance.restapi.repositories;

import com.sandbox.insurance.restapi.entities.PolicyEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends ListCrudRepository<PolicyEntity, Long> { }
