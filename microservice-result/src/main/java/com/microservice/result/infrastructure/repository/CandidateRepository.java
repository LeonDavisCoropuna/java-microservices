package com.microservice.result.infrastructure.repository;

import com.microservice.result.infrastructure.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Integer>  {

    Optional<CandidateEntity> findByPoliticalParty_Id(Integer politicalPartyId);
}
