package com.app.agritech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.agritech.entity.PersonalDetails;

@Repository
public interface PersonRepository extends CrudRepository<PersonalDetails, Long> {

  PersonalDetails findAllById(Long id);

}
