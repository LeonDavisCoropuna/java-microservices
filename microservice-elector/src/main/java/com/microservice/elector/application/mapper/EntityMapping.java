package com.microservice.elector.application.mapper;

import com.microservice.elector.domain.model.Elector;
import com.microservice.elector.domain.model.PoliticalParty;
import com.microservice.elector.domain.model.Vote;
import com.microservice.elector.infrastructure.entity.ElectorEntity;
import com.microservice.elector.infrastructure.entity.PoliticalPartyEntityDto;
import com.microservice.elector.infrastructure.entity.VoteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class EntityMapping {

    @Autowired
    private ModelMapper modelMapper;

    public Elector electorMapping (ElectorEntity electorEntity){
        return modelMapper.map(electorEntity, Elector.class);
    }

    public PoliticalParty politicalPartyMapping  (PoliticalPartyEntityDto politicalPartyEntity) {
        return modelMapper.map(politicalPartyEntity, PoliticalParty.class);
    }

    public Vote voteMapping (VoteEntity voteEntity){
        return modelMapper.map(voteEntity, Vote.class);
    }

}
