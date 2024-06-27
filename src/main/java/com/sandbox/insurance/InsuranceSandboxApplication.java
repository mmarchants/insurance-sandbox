package com.sandbox.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class InsuranceSandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceSandboxApplication.class, args);
	}

}
