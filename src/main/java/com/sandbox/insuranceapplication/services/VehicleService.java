package com.sandbox.insuranceapplication.services;

import com.sandbox.insuranceapplication.repositories.entities.VehicleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleService {

    Page<VehicleEntity> getAllVehicles(Pageable pageable);

    VehicleEntity saveVehicle(VehicleEntity vehicle);

    VehicleEntity getVehicleById(String id);

    VehicleEntity updateVehicleById(String id, VehicleEntity vehicle);

    boolean deleteVehicleById(String id);

}
