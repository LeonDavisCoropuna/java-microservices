package com.microservice.parties.domain.port;


import com.microservice.parties.domain.model.PoliticalPartiesResut;

import java.util.List;


public interface PartiesService {
    Boolean saveDataElection(List<PoliticalPartiesResut> politicalPartiesResut);
}
