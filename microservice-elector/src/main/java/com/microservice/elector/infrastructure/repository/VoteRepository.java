package com.microservice.elector.infrastructure.repository;

import com.microservice.elector.infrastructure.entity.VoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteRepository extends CrudRepository<VoteEntity, Integer> {
}
