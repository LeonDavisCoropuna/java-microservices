package com.microservice.candidate.infrastructure.controller;

import com.microservice.candidate.application.mapper.CandidateDto;
import com.microservice.candidate.application.services.CandidateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/candidate/")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateServiceImpl candidateService;

    @GetMapping("all")
    public ResponseEntity<ArrayList<CandidateDto>> getCandidateOfPoliticalParties()
    {
        ArrayList<CandidateDto> candidateDtos = candidateService.getAllCandidates();
        if(!candidateDtos.isEmpty())
        {
            return new ResponseEntity<>(candidateDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
