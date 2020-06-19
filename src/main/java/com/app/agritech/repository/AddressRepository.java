package com.app.agritech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.agritech.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

  Address findAllById(Long id);

}
