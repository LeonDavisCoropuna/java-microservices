package com.microservice.elector.infrastructure.controller;

import com.microservice.elector.application.mapper.VoteDto;
import com.microservice.elector.application.services.ElectorServiceImpl;
import com.microservice.elector.domain.model.PoliticalParty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/elector/")
@RequiredArgsConstructor
public class ElectorController {

    private final ElectorServiceImpl electorService;
    //@PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("save-vote")
    public ResponseEntity<VoteDto> saveVote(@RequestBody VoteDto vote)
    {
        if(Boolean.TRUE.equals(electorService.saveVote(vote)))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    //@PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("all-political-party")
    public ResponseEntity<ArrayList<PoliticalParty>> getAllPoliticalParty()
    {
        ArrayList<PoliticalParty> politicalParties = electorService.getPoliticalParty();
        if(!politicalParties.isEmpty())
        {
            return new ResponseEntity<>(politicalParties, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
