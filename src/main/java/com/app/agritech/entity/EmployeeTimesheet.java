package com.app.agritech.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee_timesheet")
@Data
public class EmployeeTimesheet {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "date")
  private Date date;

  @Column(name = "client_id")
  private Long clientId;

  @Column(name = "project_id")
  private Long projectId;

  @Column(name = "task_id")
  private Long taskId;

  @Column(name = "description")
  private String description;

  @Column(name = "issue_tracking_id")
  private String issueTrackingId; // Jira ticket id

  @Column(name = "hours")
  private Byte hours;

  @Column(name = "approved")
  private boolean approved;

}
