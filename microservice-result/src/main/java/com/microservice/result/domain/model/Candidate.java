package com.microservice.result.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Candidate{
    private Integer id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String email;

    //private Vote votes;
    private String job;

    private PoliticalParty politicalParty;

}
