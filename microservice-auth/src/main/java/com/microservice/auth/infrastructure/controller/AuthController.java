package com.microservice.auth.infrastructure.controller;


import com.microservice.auth.application.services.AuthService;
import com.microservice.auth.infrastructure.adapter.payload.AuthResponse;
import com.microservice.auth.infrastructure.adapter.payload.JwtResponse;
import com.microservice.auth.infrastructure.adapter.payload.LoginRequest;
import com.microservice.auth.infrastructure.adapter.payload.RegisterRequest;
import com.microservice.auth.infrastructure.adapter.payload.RoleResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest)
    {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping(value = "validate")
    public ResponseEntity<Boolean> validate(@RequestBody JwtResponse request)
    {   
        return ResponseEntity.ok(authService.validate(request));
    }
    @GetMapping("/validate")
    public ResponseEntity<RoleResponse> validateToken(@RequestParam("token") JwtResponse token) {
        if(authService.validate(token)){
            return ResponseEntity.ok(authService.validateGetToken(token));
        }
        return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
    }
}
