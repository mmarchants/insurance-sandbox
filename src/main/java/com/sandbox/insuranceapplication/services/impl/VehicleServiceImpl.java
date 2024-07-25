package com.sandbox.insuranceapplication.services.impl;

import com.sandbox.insuranceapplication.repositories.VehicleRepository;
import com.sandbox.insuranceapplication.repositories.entities.VehicleEntity;
import com.sandbox.insuranceapplication.services.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    @Override
    public List<VehicleEntity> getAllVehicles() {
        try {
            List<VehicleEntity> vehicles = repository.findAll();
            log.info("Nº of vehicles: {}", vehicles.size());
            return vehicles;
        } catch (Exception e) {
            log.error("Exception while executing 'getAllVehicles()': ", e);
        }
        return null;
    }

    @Override
    public VehicleEntity saveVehicle(VehicleEntity vehicle) {
        try {
            VehicleEntity newVehicle = repository.save(vehicle);
            if (repository.existsById(newVehicle.getId())) {
                log.info("Saved vehicle: {}", newVehicle);
                return newVehicle;
            } else {
                log.info("Vehicle {} wasn't saved", vehicle);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'saveVehicle({})': ", vehicle != null ? vehicle.toString() : null, e);
        }
        return null;
    }

    @Override
    public VehicleEntity getVehicleById(String id) {
        try {
            VehicleEntity foundVehicle = repository.findById(Long.valueOf(id)).orElse(null);
            if (foundVehicle == null) {
                log.info("No vehicle found with ID: {}", id);
            } else {
                log.info("Vehicle found with ID {}: {}", id, foundVehicle);
                return foundVehicle;
            }
        } catch (Exception e) {
            log.error("Exception while executing 'getVehicleById({})", id, e);
        }
        return null;
    }

    @Override
    public VehicleEntity updateVehicleById(String id, VehicleEntity vehicle) {
        try {
            VehicleEntity foundVehicle = this.getVehicleById(id);
            if (foundVehicle != null) {
                VehicleEntity updatedVehicle = VehicleEntity.builder()
                        .id(foundVehicle.getId())
                        .vin(vehicle.getVin())
                        .make(vehicle.getMake())
                        .model(vehicle.getModel())
                        .year(vehicle.getYear())
                        .build();
                return this.saveVehicle(updatedVehicle);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'updateVehicleById({}, {})': ", id, vehicle != null ? vehicle.toString() : null, e);
        }
        return null;
    }

    @Override
    public boolean deleteVehicleById(String id) {
        try {
            Long idNumber = Long.valueOf(id);
            if (repository.existsById(idNumber)) {
                repository.deleteById(idNumber);
                if (repository.existsById(idNumber)) {
                    log.info("Vehicle with ID {} wasn't deleted", id);
                } else {
                    log.info("Vehicle with ID {} was deleted", id);
                    return true;
                }
            } else {
                log.info("Vehicle with ID {} wasn't found", id);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'deleteVehicleById({})': ", id, e);
        }
        return false;
    }
}
