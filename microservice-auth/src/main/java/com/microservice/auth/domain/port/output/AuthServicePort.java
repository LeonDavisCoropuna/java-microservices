package com.microservice.auth.domain.port.output;



public interface AuthServicePort {
    void getPerson(String username, String password);
}
