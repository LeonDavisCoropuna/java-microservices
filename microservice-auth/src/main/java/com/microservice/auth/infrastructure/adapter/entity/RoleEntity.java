package com.microservice.auth.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.microservice.auth.application.mapper.RoleEntityDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ERole nameRole;

    // Método de conversión a ERoleDto
    public RoleEntityDto toDto( ) {
        return RoleEntityDto.builder().id(id).nameRole(nameRole.toString()).build();
    }
}
