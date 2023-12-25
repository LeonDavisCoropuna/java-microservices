package com.microservice.auth.application.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoteDto {
    private Integer idElector;
    private Integer idPoliticalParty;
    private Date date;
}
    