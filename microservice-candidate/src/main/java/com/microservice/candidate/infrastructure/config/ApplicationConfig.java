package com.microservice.candidate.infrastructure.config;


import com.microservice.candidate.application.mapper.EntityMapping;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public EntityMapping entityMapping(){
        return new EntityMapping();
    }

}