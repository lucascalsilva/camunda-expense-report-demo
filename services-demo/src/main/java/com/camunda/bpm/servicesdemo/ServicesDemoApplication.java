package com.camunda.bpm.servicesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ServicesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesDemoApplication.class, args);
	}

}

