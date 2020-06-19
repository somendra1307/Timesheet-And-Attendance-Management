package com.app.agritech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.agritech.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

  Task findAllById(Long id);

}
