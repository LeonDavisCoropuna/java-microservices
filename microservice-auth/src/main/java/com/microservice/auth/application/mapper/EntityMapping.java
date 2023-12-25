package com.microservice.auth.application.mapper;



import com.microservice.auth.domain.model.Person;
import com.microservice.auth.infrastructure.adapter.entity.PersonEntity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class EntityMapping {

    @Autowired
    private ModelMapper modelMapper;

    public Person personMapping (PersonEntity personEntity){
        return modelMapper.map(personEntity, Person.class);

    }

}
