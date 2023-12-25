package com.microservice.candidate.infrastructure.repository;


import com.microservice.candidate.infrastructure.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Integer>  {

    Optional<CandidateEntity> findByPoliticalParty_Id(Integer politicalPartyId);
}
