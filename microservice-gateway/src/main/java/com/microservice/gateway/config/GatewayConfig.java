package com.microservice.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public CustomAuthorizationFilter customAuthorizationFilter() {
        return new CustomAuthorizationFilter();
    }
}
