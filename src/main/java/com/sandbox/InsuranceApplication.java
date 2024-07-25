package com.sandbox;

import com.sandbox.insuranceapplication.util.YAMLConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class InsuranceApplication implements CommandLineRunner {

	@Autowired
	private YAMLConfig appConfig;

	public static void main(String[] args) {
		SpringApplication.run(InsuranceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("********** Application config {} **********", appConfig.getName());
		log.info("Environment: {}", appConfig.getEnvironment());
		log.info("Enabled: {}", appConfig.isEnabled());
		log.info("Servers: {}", appConfig.getServers());
	}
}
