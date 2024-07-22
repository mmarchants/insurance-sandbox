package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.entities.VehicleEntity;

import java.util.List;

public interface VehicleService {

    List<VehicleEntity> getAllVehicles();

    VehicleEntity saveVehicle(VehicleEntity vehicle);

    VehicleEntity getVehicleById(Long id);

    VehicleEntity updateVehicleById(Long id, VehicleEntity vehicle);

    boolean deleteVehicleById(Long id);

}
