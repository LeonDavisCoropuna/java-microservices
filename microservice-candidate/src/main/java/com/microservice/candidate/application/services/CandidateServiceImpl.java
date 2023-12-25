package com.microservice.candidate.application.services;

import com.microservice.candidate.application.mapper.CandidateDto;
import com.microservice.candidate.application.mapper.EntityMapping;
import com.microservice.candidate.domain.model.Candidate;
import com.microservice.candidate.domain.port.output.CandidateServicePort;
import com.microservice.candidate.infrastructure.entity.CandidateEntity;
import com.microservice.candidate.infrastructure.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@AllArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateServicePort {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private final EntityMapping entityMapping;

    @Override
    public ArrayList<CandidateDto> getAllCandidates() {
        ArrayList<CandidateDto> candidates = new ArrayList<>();

        Iterable<CandidateEntity> candidateIterable = candidateRepository.findAll();

        // Iterar sobre los candidatos y obtener información adicional
        for (CandidateEntity candidateEntity : candidateIterable) {

            Candidate newCandidate = entityMapping.candidateMapping(candidateEntity);

            CandidateDto newCandidateDto = new CandidateDto();

            // Obtener datos personales del candidato
            newCandidateDto.setId( newCandidate.getId() );
            newCandidateDto.setCandidateName(newCandidate.getName());
            newCandidateDto.setCandidateLastName(newCandidate.getLastName());
            newCandidateDto.setUserName(newCandidate.getUserName());
            newCandidateDto.setJob(newCandidate.getJob());

            // Obtener datos del partido político
            newCandidateDto.setNamePoliticalParty(newCandidate.getPoliticalParty().getNamePoliticalParty());

            candidates.add(newCandidateDto);
        }

        return candidates;
    }

}
