package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;
import com.sandbox.insuranceapplication.repositories.entities.DriverEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DriverService {

    Page<DriverEntity> getAllDrivers(Pageable pageable);

    DriverEntity saveDriver(DriverEntity driver);

    DriverEntity getDriverById(Long id);

    DriverEntity updateDriverById(Long id, DriverEntity driver);

    boolean deleteDriverById(Long id);

    Page<ClaimEntity> getDriverClaims(Pageable pageable, String driversLicense);

}
