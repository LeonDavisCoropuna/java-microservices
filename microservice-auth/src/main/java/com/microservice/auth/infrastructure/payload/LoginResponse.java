package com.microservice.auth.infrastructure.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.microservice.auth.application.mapper.RoleEntityDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String name;
    private String userName;
    private String password;
    private Set<RoleEntityDto> roles;
}
