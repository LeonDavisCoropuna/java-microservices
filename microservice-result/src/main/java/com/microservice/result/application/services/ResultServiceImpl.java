package com.microservice.result.application.services;

import com.microservice.result.application.mapper.EntityMapping;
import com.microservice.result.application.mapper.ResultDto;
import com.microservice.result.domain.model.Candidate;
import com.microservice.result.domain.model.PoliticalParty;
import com.microservice.result.domain.port.output.ResultServicePort;
import com.microservice.result.infrastructure.entity.CandidateEntity;
import com.microservice.result.infrastructure.entity.PoliticalPartyEntityDto;
import com.microservice.result.infrastructure.repository.CandidateRepository;
import com.microservice.result.infrastructure.repository.PoliticalPartyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Service
public class ResultServiceImpl implements ResultServicePort {

    @Autowired
    private PoliticalPartyRepository politicalPartyRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private final EntityMapping entityMapping;

    @Override
    public ArrayList<ResultDto> getResult() {

        Iterable<PoliticalPartyEntityDto> resultEntities = politicalPartyRepository.findAll();

        ArrayList<ResultDto> electionResults = new ArrayList<>();

        for (PoliticalPartyEntityDto politicalPartyEntity : resultEntities) {

            // Obtener y asignar datos del partido político
            PoliticalParty politicalParty = entityMapping.politicalPartyMapping(politicalPartyEntity);

            // Obtener y asignar datos del candidato
            CandidateEntity candidateEntity = candidateRepository.findByPoliticalParty_Id( politicalParty.getId() ).orElse(null);
            Candidate candidate = new Candidate();
            if (candidateEntity != null) {
                candidate = entityMapping.candidateMapping(candidateEntity);
            }


            ResultDto newResultDto = new ResultDto();

            newResultDto.setIdCandidate( candidate.getId() );
            newResultDto.setNameCandidate( candidate.getName() );
            newResultDto.setLastNameCandidate( candidate.getLastName() );
            newResultDto.setJobCandidate( candidate.getJob() );

            newResultDto.setIdPoliticalParty( politicalParty.getId() );
            newResultDto.setNamePoliticalParty( politicalParty.getNamePoliticalParty() );
            newResultDto.setNumVotes( politicalParty.getNumVotes() );


            // Agregar el nuevo resultado a la lista
            electionResults.add(newResultDto);
        }
        return electionResults;
    }

}