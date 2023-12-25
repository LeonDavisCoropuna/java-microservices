package com.microservice.elector.domain.port.input;



import com.microservice.elector.application.mapper.VoteDto;
import com.microservice.elector.domain.model.PoliticalParty;

import java.util.ArrayList;

public interface ElectorServicePort {
    Boolean saveVote(VoteDto vote);
    PoliticalParty getResultVoteOfPoliticalParty(Integer idPoliticalParty);
    ArrayList<PoliticalParty> getPoliticalParty();

}
