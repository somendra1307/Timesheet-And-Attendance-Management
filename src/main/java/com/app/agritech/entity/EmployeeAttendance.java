package com.app.agritech.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "emp_attendance")
@Entity
@Data
public class EmployeeAttendance {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Long userId;

  private Date date;

  private String punchInTime;

  private String punchOutTime;

  private String attendance;

  private String remark;

  private boolean approved;

}
