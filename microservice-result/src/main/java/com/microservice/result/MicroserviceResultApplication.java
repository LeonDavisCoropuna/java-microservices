package com.microservice.result;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceResultApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceResultApplication.class, args);
	}

}
