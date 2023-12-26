package com.microservice.parties.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PoliticalPartiesResut {
    private Integer idCandidate;
    private String nameCandidate;
    private String lastNameCandidate;
    private String jobCandidate;

    private Integer idPoliticalParty;
    private String namePoliticalParty;
    private Integer numVotes;
}

