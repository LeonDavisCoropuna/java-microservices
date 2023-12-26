package com.microservice.parties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePartiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicePartiesApplication.class, args);
    }

}
