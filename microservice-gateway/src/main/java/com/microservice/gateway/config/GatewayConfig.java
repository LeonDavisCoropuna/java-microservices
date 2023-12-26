package com.microservice.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.microservice.gateway.filter.CustomAuthorizationFilter;

@Configuration
public class GatewayConfig {

    @Bean
    public CustomAuthorizationFilter customAuthorizationFilter() {
        return new CustomAuthorizationFilter();
    }
    @Bean
    public RestTemplate template(){
       return new RestTemplate();
    }
}
