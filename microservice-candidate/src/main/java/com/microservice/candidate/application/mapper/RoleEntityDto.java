package com.microservice.candidate.application.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntityDto {

    private Integer id;

    private ERole nameRole;
}
