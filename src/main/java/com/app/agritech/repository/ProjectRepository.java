package com.app.agritech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.agritech.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

  Project findAllById(Long id);

}
