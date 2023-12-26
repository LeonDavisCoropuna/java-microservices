package com.microservice.parties.infrastructure.controller;

import com.microservice.parties.application.service.PartiesServiceImpl;
import com.microservice.parties.domain.model.PartiesResult;
import com.microservice.parties.domain.model.PoliticalPartiesResut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/parties")
public class PartiesController {
    @Autowired
    PartiesServiceImpl partiesService;

    @PostMapping("/register")
    public ResponseEntity<List<PoliticalPartiesResut>> saveElection(@RequestBody List<PoliticalPartiesResut> politicalPartiesResut)
    {
        if (partiesService.saveDataElection(politicalPartiesResut))
            return new ResponseEntity<>(HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
