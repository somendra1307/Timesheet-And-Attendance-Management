package com.app.agritech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.agritech.entity.UserDetails;


@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {

    UserDetails findAllById(Long id);

    UserDetails findAllByEmailId(String id);

    UserDetails findAllByEmailIdAndPassword(String userId, String password);

}
