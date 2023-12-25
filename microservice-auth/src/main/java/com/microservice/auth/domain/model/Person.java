package com.microservice.auth.domain.model;

import com.microservice.auth.application.mapper.RoleEntityDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {

    private Integer id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private Set<String> roles = new HashSet<>();

}
