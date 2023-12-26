package com.microservice.parties.infrastructure.repository;

import com.microservice.parties.domain.model.PartiesResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartiesRepository extends MongoRepository<PartiesResult, String> {
}
