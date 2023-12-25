package com.microservice.elector.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Elector {
    private Integer id;
    private String name;
    private String lastName;
    private String userName;
    private String password;

    private Vote votes;

}
