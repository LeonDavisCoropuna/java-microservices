package com.microservice.result.infrastructure.controller;

import com.microservice.result.application.mapper.ResultDto;
import com.microservice.result.application.services.ResultServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/result/")
@RequiredArgsConstructor
public class ResultController {
    private final ResultServiceImpl resultService;

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("online-results")
    public ResponseEntity<ArrayList<ResultDto>> getResultsElectionOnline()
    {
        ArrayList<ResultDto> resultDtos = resultService.getResult();
        if(!resultDtos.isEmpty())
        {
            return new ResponseEntity<>(resultDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
