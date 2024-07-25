package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;
import com.sandbox.insuranceapplication.repositories.entities.DriverEntity;

import java.util.List;

public interface DriverService {

    List<DriverEntity> getAllDrivers();

    DriverEntity saveDriver(DriverEntity driver);

    DriverEntity getDriverById(Long id);

    DriverEntity updateDriverById(Long id, DriverEntity driver);

    boolean deleteDriverById(Long id);

    List<ClaimEntity> getDriverClaims(String driversLicense);

}
