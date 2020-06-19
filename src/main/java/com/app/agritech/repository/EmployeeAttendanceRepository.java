package com.app.agritech.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.agritech.entity.EmployeeAttendance;

@Repository
public interface EmployeeAttendanceRepository extends CrudRepository<EmployeeAttendance, Long> {

  EmployeeAttendance findAllById(Long id);

  List<EmployeeAttendance> findAllByUserId(Long userId);

}
