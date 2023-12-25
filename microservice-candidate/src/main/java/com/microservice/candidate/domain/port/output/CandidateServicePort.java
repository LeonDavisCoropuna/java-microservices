package com.microservice.candidate.domain.port.output;



import com.microservice.candidate.application.mapper.CandidateDto;

import java.util.ArrayList;

public interface CandidateServicePort {
    ArrayList<CandidateDto> getAllCandidates();
}
