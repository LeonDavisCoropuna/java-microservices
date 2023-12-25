package com.microservice.auth.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.auth.infrastructure.adapter.entity.PersonEntity;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {

    Optional<PersonEntity> findByUserName(String username);

}
