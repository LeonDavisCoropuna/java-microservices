package com.microservice.result.application.mapper;

import com.microservice.result.domain.model.Candidate;
import com.microservice.result.domain.model.PoliticalParty;
import com.microservice.result.infrastructure.entity.CandidateEntity;
import com.microservice.result.infrastructure.entity.PoliticalPartyEntityDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class EntityMapping {

    @Autowired
    private ModelMapper modelMapper;

    public Candidate candidateMapping(CandidateEntity candidateEntity)
    {
        return modelMapper.map(candidateEntity, Candidate.class);
    }

    public PoliticalParty politicalPartyMapping  (PoliticalPartyEntityDto politicalPartyEntity) {
        return modelMapper.map(politicalPartyEntity, PoliticalParty.class);
    }

}
