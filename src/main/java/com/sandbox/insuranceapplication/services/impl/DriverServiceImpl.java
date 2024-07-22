package com.sandbox.insuranceapplication.services.impl;

import com.sandbox.insuranceapplication.repositories.DriverRepository;
import com.sandbox.insuranceapplication.repositories.entities.DriverEntity;
import com.sandbox.insuranceapplication.services.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    @Override
    public List<DriverEntity> getAllDrivers() {
        try {
            List<DriverEntity> drivers = repository.findAll();
            log.info("Nº of drivers: {}", drivers.size());
            return drivers;
        } catch (Exception e) {
            log.error("Exception while executing 'getAllDrivers()': ", e);
        }
        return null;
    }

    @Override
    public DriverEntity saveDriver(DriverEntity driver) {
        try {
            DriverEntity newDriver = repository.save(driver);
            if (repository.existsById(newDriver.getId())) {
                log.info("Saved driver: {}", newDriver);
                return newDriver;
            } else {
                log.info("Driver {} wasn't saved", driver);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'saveDriver({})': ", driver != null ? driver.toString() : null, e);
        }
        return null;
    }

    @Override
    public DriverEntity getDriverById(Long id) {
        try {
            DriverEntity foundDriver = repository.findById(id).orElse(null);
            if (foundDriver == null) {
                log.info("No driver found with ID: {}", id);
            } else {
                log.info("Driver found with ID {}: {}", id, foundDriver);
                return foundDriver;
            }
        } catch (Exception e) {
            log.error("Exception while executing 'getDriverById({})': ", id, e);
        }
        return null;
    }

    @Override
    public DriverEntity updateDriverById(Long id, DriverEntity driver) {

        try {
            DriverEntity foundDriver = this.getDriverById(id);
            if (foundDriver != null) {
                DriverEntity updatedDriver = DriverEntity.builder()
                        .id(foundDriver.getId())
                        .name(driver.getName())
                        .surname(driver.getSurname())
                        .phoneNumber(driver.getPhoneNumber())
                        .email(driver.getEmail())
                        .dateOfBirth(driver.getDateOfBirth())
                        .driversLicence(driver.getDriversLicence())
                        .build();
                return this.saveDriver(updatedDriver);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'updateDriverById({}, {})': ", id, driver != null ? driver.toString() : null, e);
        }
        return null;
    }

    @Override
    public boolean deleteDriverById(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                if (repository.existsById(id)) {
                    log.info("Driver with ID {} wasn't deleted", id);
                } else {
                    log.info("Driver with ID {} was deleted", id);
                    return true;
                }
            } else {
                log.info("Driver with ID {} wasn't found", id);
            }
        } catch (Exception e) {
            log.error("Exception while executing 'deleteDriverById({})': ", id, e);
        }
        return false;
    }
}
