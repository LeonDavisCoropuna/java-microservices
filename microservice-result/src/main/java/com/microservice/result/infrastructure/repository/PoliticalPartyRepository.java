package com.microservice.result.infrastructure.repository;

import com.microservice.result.infrastructure.entity.PoliticalPartyEntityDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PoliticalPartyRepository extends CrudRepository<PoliticalPartyEntityDto, Integer> {

}
