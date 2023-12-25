package com.microservice.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @GetMapping("/all")
    public ResponseEntity<?> hellowAuth(){
        return ResponseEntity.ok("DESDE AUTH");
    }
}
