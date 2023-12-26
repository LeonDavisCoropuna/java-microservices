package com.microservice.parties.application.service;

import com.microservice.parties.domain.model.PartiesResult;
import com.microservice.parties.domain.model.PoliticalPartiesResut;
import com.microservice.parties.domain.port.PartiesService;
import com.microservice.parties.infrastructure.repository.PartiesRepository;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class PartiesServiceImpl implements PartiesService {

    @Autowired
    PartiesRepository partiesRepository;
    @Override
    public Boolean saveDataElection(List<PoliticalPartiesResut> politicalPartiesResut) {
        PartiesResult partiesResult = new PartiesResult();
        partiesResult.setDate(new Date());
        partiesResult.setParties(politicalPartiesResut);

        try{
            partiesRepository.save(partiesResult);

            return true;
        } catch (DuplicateKeyException e) {
            System.out.println("Error de clave duplicada: " + e.getMessage());
            return false;
        } catch (DataAccessException e) {
            System.out.println("Error de acceso a datos: " + e.getMessage());
            return false;
        }
        catch (Exception e) {
            System.out.println("Error desconocido: " + e.getMessage());
            return false;
        }
    }
}
