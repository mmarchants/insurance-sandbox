package com.sandbox.insuranceapplication.controllers;


import com.sandbox.insuranceapplication.repositories.entities.VehicleEntity;
import com.sandbox.insuranceapplication.services.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleController {

    private final VehicleService service;

    @GetMapping("/vehicles")
    public List<VehicleEntity> getAllVehicles() {
        log.info("GET /vehicles");
        return service.getAllVehicles();
    }

    @PostMapping("/vehicle")
    public VehicleEntity saveVehicle(@Valid @RequestBody VehicleEntity vehicle) {
        log.info("POST /vehicle");
        return service.saveVehicle(vehicle);
    }

    @GetMapping("/vehicle/{id}")
    public VehicleEntity getVehicleById(@PathVariable("id") String id) {
        log.info("GET /vehicle/{}", id);
        return service.getVehicleById(id);
    }

    @PutMapping("/vehicle/{id}")
    public VehicleEntity updateVehicleById(@PathVariable("id") String id, @Valid @RequestBody VehicleEntity vehicle) {
        log.info("PUT /vehicle/{}", id);
        return service.updateVehicleById(id, vehicle);
    }

    @DeleteMapping("/vehicle/{id}")
    public boolean deleteVehicleById(@PathVariable String id) {
        log.info("DELETE /vehicle/{}", id);
        return service.deleteVehicleById(id);
    }

}
