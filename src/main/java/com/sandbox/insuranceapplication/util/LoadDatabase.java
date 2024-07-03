package com.sandbox.insuranceapplication.util;

import com.sandbox.insuranceapplication.repositories.records.Policy;
import com.sandbox.insuranceapplication.repositories.PolicyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PolicyRepository repository) {
        return args -> {
            log.info("Preloading: {}", repository.save(Policy.builder().id(1L).name("11-12345A-01-01").active(false).build().toEntity()));
            log.info("Preloading: {}", repository.save(Policy.builder().id(2L).name("11-12345A-02-01").active(true).build().toEntity()));
            log.info("Preloading: {}", repository.save(Policy.builder().id(3L).name("22-12345B-01-01").active(false).build().toEntity()));
            log.info("Preloading: {}", repository.save(Policy.builder().id(4L).name("22-12345B-01-02").active(true).build().toEntity()));
            log.info("Preloading: {}", repository.save(Policy.builder().id(5L).name("33-12345C-01-01").active(true).build().toEntity()));
            log.info("Preloading: {}", repository.save(Policy.builder().id(6L).name("33-12345D-00-01").active(false).build().toEntity()));
        };

    }
}
