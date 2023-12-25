package com.microservice.result.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//model domain
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PoliticalParty {

    private Integer id;
    private String namePoliticalParty;
    private Integer numVotes;
}
