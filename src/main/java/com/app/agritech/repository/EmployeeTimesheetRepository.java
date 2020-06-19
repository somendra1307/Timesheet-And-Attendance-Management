package com.app.agritech.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.agritech.entity.EmployeeTimesheet;

@Repository
public interface EmployeeTimesheetRepository extends CrudRepository<EmployeeTimesheet, Long> {

  EmployeeTimesheet findAllById(Long id);

  List<EmployeeTimesheet> findAllByUserId(Long userId);

}
