package com.microservice.auth.application.services;


import com.microservice.auth.application.mapper.RoleEntityDto;
import com.microservice.auth.infrastructure.adapter.entity.PersonEntity;
import com.microservice.auth.infrastructure.adapter.entity.RoleEntity;
import com.microservice.auth.infrastructure.adapter.jwt.JwtUtils;
import com.microservice.auth.infrastructure.adapter.payload.JwtResponse;
import com.microservice.auth.infrastructure.payload.LoginRequest;
import com.microservice.auth.infrastructure.payload.LoginResponse;
import com.microservice.auth.infrastructure.payload.RegisterRequest;
import com.microservice.auth.infrastructure.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collector;
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


    public Boolean register(@NotNull RegisterRequest request) {

        // Set<RoleEntity> roles = request.getRoles().stream()
        //         .map(role -> RoleEntity.builder()
        //                 .nameRole(ERole.valueOf(role))
        //                 .build())
        //         .collect(Collectors.toSet());

        // PersonEntity user = PersonEntity.builder()
        //         .name(request.getName())
        //         .userName(request.getUserName())
        //         .lastName(request.getLastName())
        //         .password(passwordEncoder.encode( request.getPassword()))
        //         .roles(roles)
        //         .build();


        // userRepository.save(user);

//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
//        return AuthResponse.builder()
//                .token(jwtUtils.generateJwtToken(authentication))
//                .build();
        return true;
    }


}