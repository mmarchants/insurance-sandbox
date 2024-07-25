package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.entities.VehicleEntity;

import java.util.List;

public interface VehicleService {

    List<VehicleEntity> getAllVehicles();

    VehicleEntity saveVehicle(VehicleEntity vehicle);

    VehicleEntity getVehicleById(String id);

    VehicleEntity updateVehicleById(String id, VehicleEntity vehicle);

    boolean deleteVehicleById(String id);

}
