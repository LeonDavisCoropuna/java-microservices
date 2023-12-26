package com.microservice.auth.application.services;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.microservice.auth.infrastructure.adapter.entity.ERole;
import com.microservice.auth.infrastructure.adapter.entity.PersonEntity;
import com.microservice.auth.infrastructure.adapter.entity.RoleEntity;
import com.microservice.auth.infrastructure.adapter.jwt.JwtUtils;
import com.microservice.auth.infrastructure.adapter.payload.AuthResponse;
import com.microservice.auth.infrastructure.adapter.payload.JwtResponse;
import com.microservice.auth.infrastructure.adapter.payload.LoginRequest;
import com.microservice.auth.infrastructure.adapter.payload.RegisterRequest;
import com.microservice.auth.infrastructure.adapter.payload.RoleResponse;
import com.microservice.auth.infrastructure.repository.PersonRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final PersonRepository userRepository;

    public JwtResponse login(@NotNull LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());


        Map<String, Object> claims = new HashMap<>();
        claims.put("roles",roles);
        claims.put("id_person", userDetails.getId());
        String jwt = jwtUtils.generateJwtToken(authentication,claims);

        return new JwtResponse(jwt);
    }


    public AuthResponse register(@NotNull RegisterRequest request) {

        Set<String> strRoles = request.getRoles();
        Set<RoleEntity> roles = request.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .nameRole(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());
        String pass = passwordEncoder.encode(request.getPassword());

        PersonEntity user = PersonEntity.builder()
                .name(request.getName())
                .userName(request.getUserName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode( request.getPassword()))
                .roles(roles)
                .build();


        userRepository.save(user);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        return AuthResponse.builder()
                .token(jwtUtils.generateJwtToken(authentication))
                .build();
    }
    public boolean validate(@NotNull JwtResponse  token)
    {
        return jwtUtils.validateJwtToken(token.getToken());
    }
     public RoleResponse validateGetToken(@NotNull JwtResponse token)
    {
        if(jwtUtils.validateJwtToken(token.getToken())){
           return RoleResponse.builder().roles(jwtUtils.getUserRolesFromJwtToken(token.getToken())).build();
        }
        return null;
    }
}