package com.sandbox.insuranceapplication.repositories;

import com.sandbox.insuranceapplication.repositories.entities.VehicleEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends ListCrudRepository<VehicleEntity, Long> { }
