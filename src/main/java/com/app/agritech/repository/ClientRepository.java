package com.app.agritech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.agritech.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

  Client findAllById(Long id);

}
