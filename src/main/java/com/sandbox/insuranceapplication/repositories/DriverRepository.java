package com.sandbox.insuranceapplication.repositories;

import com.sandbox.insuranceapplication.repositories.entities.DriverEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends ListCrudRepository<DriverEntity, Long> { }
