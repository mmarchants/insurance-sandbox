package com.sandbox.insuranceapplication.util;

import com.sandbox.insuranceapplication.repositories.ClaimRepository;
import com.sandbox.insuranceapplication.repositories.DriverRepository;
import com.sandbox.insuranceapplication.repositories.PolicyRepository;
import com.sandbox.insuranceapplication.repositories.VehicleRepository;
import com.sandbox.insuranceapplication.repositories.entities.ClaimEntity;
import com.sandbox.insuranceapplication.repositories.entities.DriverEntity;
import com.sandbox.insuranceapplication.repositories.entities.PolicyEntity;
import com.sandbox.insuranceapplication.repositories.entities.VehicleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@Slf4j
class LoadDatabase {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            log.info("Preloading sample objects...");
            // Preload Policies
            PolicyEntity policy1 = policyRepository.save(PolicyEntity.builder().id(1L).name("11-12345A-01-01").active(true).build());
            PolicyEntity policy2 = policyRepository.save(PolicyEntity.builder().id(2L).name("11-12345A-02-01").active(true).build());
            PolicyEntity policy3 = policyRepository.save(PolicyEntity.builder().id(3L).name("22-12345B-01-01").active(false).build());
            PolicyEntity policy4 = policyRepository.save(PolicyEntity.builder().id(4L).name("22-12345B-01-02").active(true).build());
            PolicyEntity policy5 = policyRepository.save(PolicyEntity.builder().id(5L).name("33-12345C-01-01").active(true).build());
            PolicyEntity policy6 = policyRepository.save(PolicyEntity.builder().id(6L).name("33-12345D-00-01").active(false).build());
            PolicyEntity policy7 = policyRepository.save(PolicyEntity.builder().id(7L).name("44-12345E-00-01").active(true).build());
            PolicyEntity policy8 = policyRepository.save(PolicyEntity.builder().id(8L).name("44-12345F-00-01").active(false).build());
            PolicyEntity policy9 = policyRepository.save(PolicyEntity.builder().id(9L).name("55-12345G-00-01").active(true).build());
            PolicyEntity policy10 = policyRepository.save(PolicyEntity.builder().id(10L).name("55-12345H-00-01").active(true).build());
            log.info("Preloaded policies.");

            // Preload Vehicles with Policies
            vehicleRepository.save(VehicleEntity.builder().id(1L).vin("1234567890ABC").make("Toyota").model("Corolla").year(2016).policy(policy1).build());
            vehicleRepository.save(VehicleEntity.builder().id(1L).vin("1234567890ABC").make("Toyota").model("Corolla").year(2016).policy(policy1).build());
            vehicleRepository.save(VehicleEntity.builder().id(2L).vin("2345678901DEF").make("Honda").model("Civic").year(2018).policy(policy1).build());
            vehicleRepository.save(VehicleEntity.builder().id(3L).vin("3456789012GHI").make("Ford").model("Mustang").year(2020).policy(policy2).build());
            vehicleRepository.save(VehicleEntity.builder().id(4L).vin("4567890123JKL").make("Chevrolet").model("Camaro").year(2017).policy(policy2).build());
            vehicleRepository.save(VehicleEntity.builder().id(5L).vin("5678901234MNO").make("Nissan").model("Altima").year(2019).policy(policy3).build());
            vehicleRepository.save(VehicleEntity.builder().id(6L).vin("6789012345PQR").make("BMW").model("3 Series").year(2021).policy(policy3).build());
            vehicleRepository.save(VehicleEntity.builder().id(7L).vin("7890123456STU").make("Mercedes-Benz").model("C-Class").year(2015).policy(policy4).build());
            vehicleRepository.save(VehicleEntity.builder().id(8L).vin("8901234567VWX").make("Audi").model("A4").year(2018).policy(policy4).build());
            vehicleRepository.save(VehicleEntity.builder().id(9L).vin("9012345678YZA").make("Lexus").model("ES").year(2022).policy(policy5).build());
            vehicleRepository.save(VehicleEntity.builder().id(10L).vin("0123456789BCD").make("Tesla").model("Model 3").year(2023).policy(policy5).build());
            log.info("Preloaded vehicles.");

            // Preload Drivers with Policies
            driverRepository.save(DriverEntity.builder().id(1L).name("John").surname("Doe").phoneNumber("123-456-7890").email("john.doe@example.com").dateOfBirth(LocalDate.of(1980, 1, 1)).driversLicence("D123456").policy(policy1).build());
            driverRepository.save(DriverEntity.builder().id(2L).name("Jane").surname("Smith").phoneNumber("098-765-4321").email("jane.smith@example.com").dateOfBirth(LocalDate.of(1990, 2, 2)).driversLicence("D654321").policy(policy1).build());
            driverRepository.save(DriverEntity.builder().id(3L).name("Mike").surname("Johnson").phoneNumber("111-222-3333").email("mike.johnson@example.com").dateOfBirth(LocalDate.of(1985, 3, 3)).driversLicence("D112233").policy(policy2).build());
            driverRepository.save(DriverEntity.builder().id(4L).name("Emily").surname("Davis").phoneNumber("444-555-6666").email("emily.davis@example.com").dateOfBirth(LocalDate.of(1975, 4, 4)).driversLicence("D445566").policy(policy2).build());
            driverRepository.save(DriverEntity.builder().id(5L).name("David").surname("Miller").phoneNumber("777-888-9999").email("david.miller@example.com").dateOfBirth(LocalDate.of(1995, 5, 5)).driversLicence("D778899").policy(policy3).build());
            driverRepository.save(DriverEntity.builder().id(6L).name("Sarah").surname("Wilson").phoneNumber("222-333-4444").email("sarah.wilson@example.com").dateOfBirth(LocalDate.of(1982, 6, 6)).driversLicence("D223344").policy(policy3).build());
            driverRepository.save(DriverEntity.builder().id(7L).name("Robert").surname("Moore").phoneNumber("555-666-7777").email("robert.moore@example.com").dateOfBirth(LocalDate.of(1988, 7, 7)).driversLicence("D556677").policy(policy4).build());
            driverRepository.save(DriverEntity.builder().id(8L).name("Linda").surname("Taylor").phoneNumber("888-999-0000").email("linda.taylor@example.com").dateOfBirth(LocalDate.of(1983, 8, 8)).driversLicence("D889900").policy(policy4).build());
            driverRepository.save(DriverEntity.builder().id(9L).name("Michael").surname("Anderson").phoneNumber("333-444-5555").email("michael.anderson@example.com").dateOfBirth(LocalDate.of(1978, 9, 9)).driversLicence("D334455").policy(policy5).build());
            driverRepository.save(DriverEntity.builder().id(10L).name("Elizabeth").surname("Thomas").phoneNumber("666-777-8888").email("elizabeth.thomas@example.com").dateOfBirth(LocalDate.of(1992, 10, 10)).driversLicence("D667788").policy(policy5).build());
            log.info("Preloaded drivers.");


            // Preload Claims linked to Drivers
            claimRepository.save(ClaimEntity.builder().id(1L).description("Accident on highway").claimDate(LocalDate.of(2021, 1, 10)).identifier("CLM-48293710").driver(driverRepository.findById(1L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(2L).description("Minor collision").claimDate(LocalDate.of(2021, 2, 20)).identifier("CLM-57382914").driver(driverRepository.findById(2L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(3L).description("Windshield damage").claimDate(LocalDate.of(2021, 3, 15)).identifier("CLM-98127346").driver(driverRepository.findById(3L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(4L).description("Theft").claimDate(LocalDate.of(2021, 4, 25)).identifier("CLM-46738291").driver(driverRepository.findById(4L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(5L).description("Fire damage").claimDate(LocalDate.of(2021, 5, 30)).identifier("CLM-75829416").driver(driverRepository.findById(5L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(6L).description("Flood damage").claimDate(LocalDate.of(2021, 6, 12)).identifier("CLM-83920174").driver(driverRepository.findById(6L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(7L).description("Hit and run").claimDate(LocalDate.of(2021, 7, 4)).identifier("CLM-17294830").driver(driverRepository.findById(7L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(8L).description("Vandalism").claimDate(LocalDate.of(2021, 8, 18)).identifier("CLM-38492017").driver(driverRepository.findById(8L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(9L).description("Animal collision").claimDate(LocalDate.of(2021, 9, 22)).identifier("CLM-92731845").driver(driverRepository.findById(9L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(10L).description("Major accident").claimDate(LocalDate.of(2021, 1, 5)).identifier("CLM-61928347").driver(driverRepository.findById(10L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(11L).description("Fender bender").claimDate(LocalDate.of(2021, 1, 13)).identifier("CLM-74829301").driver(driverRepository.findById(1L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(12L).description("Parking lot incident").claimDate(LocalDate.of(2021, 1, 1)).identifier("CLM-29481736").driver(driverRepository.findById(2L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(13L).description("Road debris damage").claimDate(LocalDate.of(2022, 1, 20)).identifier("CLM-83729164").driver(driverRepository.findById(3L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(14L).description("Tire damage").claimDate(LocalDate.of(2022, 2, 28)).identifier("CLM-56192837").driver(driverRepository.findById(4L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(15L).description("Engine failure").claimDate(LocalDate.of(2022, 3, 15)).identifier("CLM-92837451").driver(driverRepository.findById(5L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(16L).description("Brake failure").claimDate(LocalDate.of(2022, 4, 18)).identifier("CLM-37184925").driver(driverRepository.findById(6L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(17L).description("Rear-end collision").claimDate(LocalDate.of(2022, 5, 22)).identifier("CLM-28419307").driver(driverRepository.findById(7L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(18L).description("Side swipe").claimDate(LocalDate.of(2022, 6, 29)).identifier("CLM-17382964").driver(driverRepository.findById(8L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(19L).description("Rollover accident").claimDate(LocalDate.of(2022, 7, 9)).identifier("CLM-39281746").driver(driverRepository.findById(9L).orElse(null)).build());
            claimRepository.save(ClaimEntity.builder().id(20L).description("Tree damage").claimDate(LocalDate.of(2022, 8, 14)).identifier("CLM-71829340").driver(driverRepository.findById(10L).orElse(null)).build());
            log.info("Preloaded claims.");

            log.info("Done.");
        };
    }
}
