package com.microservice.candidate.application.mapper;


import com.microservice.candidate.domain.model.Candidate;
import com.microservice.candidate.infrastructure.entity.CandidateEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class EntityMapping {

    @Autowired
    private ModelMapper modelMapper;

    public Candidate candidateMapping(CandidateEntity candidateEntity)
    {
        return modelMapper.map(candidateEntity, Candidate.class);
    }

}
