package com.microservice.elector.infrastructure.repository;

import com.microservice.elector.infrastructure.entity.ElectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ElectorRepository extends CrudRepository<ElectorEntity, Integer> {
}
