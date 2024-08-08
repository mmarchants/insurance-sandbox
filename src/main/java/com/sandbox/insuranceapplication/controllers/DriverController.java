package com.sandbox.insuranceapplication.controllers;

import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;
import com.sandbox.insuranceapplication.repositories.entities.DriverEntity;
import com.sandbox.insuranceapplication.services.DriverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DriverController {

    private final DriverService service;

    @GetMapping("/drivers")
    public Page<DriverEntity> getAllDrivers(
            @PageableDefault(page = 0, size = 10, sort = {"policy", "dateOfBirth"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        log.info("GET /drivers");
        return service.getAllDrivers(pageable);
    }

    @PostMapping("/driver")
    public DriverEntity saveDriver(@Valid @RequestBody DriverEntity driver) {
        log.info("POST /driver");
        return service.saveDriver(driver);
    }

    @GetMapping("/driver/{id}")
    public DriverEntity getDriverById(@PathVariable("id") Long id) {
        log.info("GET /driver/{}", id);
        return service.getDriverById(id);
    }

    @PutMapping("/driver/{id}")
    public DriverEntity updateDriverById(@PathVariable("id") Long id, @Valid @RequestBody DriverEntity driver) {
        log.info("PUT /driver/{}", id);
        return service.updateDriverById(id, driver);
    }

    @DeleteMapping("/driver/{id}")
    public boolean deleteDriverById(@PathVariable Long id) {
        log.info("DELETE /driver/{}", id);
        return service.deleteDriverById(id);
    }

    @GetMapping("/driver/{driversLicense}/claims")
    public Page<ClaimEntity> getDriverClaims(
            @PageableDefault(page = 0, size = 10, sort = {"claimDate"}, direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable("driversLicense") String driversLicense) {
        log.info("GET /driver/{}/claims", driversLicense);
        return service.getDriverClaims(pageable, driversLicense);
    }

}
