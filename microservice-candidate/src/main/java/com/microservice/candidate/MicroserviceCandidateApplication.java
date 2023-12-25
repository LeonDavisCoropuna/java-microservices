package com.microservice.candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceCandidateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCandidateApplication.class, args);
    }

}
