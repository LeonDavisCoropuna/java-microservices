package com.microservice.auth.infrastructure.controller;


import com.microservice.auth.application.services.AuthService;
import com.microservice.auth.infrastructure.payload.JwtResponse;
import com.microservice.auth.infrastructure.payload.LoginRequest;
import com.microservice.auth.infrastructure.payload.LoginResponse;
import com.microservice.auth.infrastructure.payload.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)
    {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping(value = "register")
    public ResponseEntity<Boolean> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}
