package com.app.agritech.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "personal_details")
@Data
public class PersonalDetails {

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "present_address_id")
  private Address presentAddress;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "permanent_address_id")
  private Address permanentAddress;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "emergency_contact_no" )
  private Long emergencyContactNo;

  @Column(name = "birth_date")
  private Date birthDate;

  @Column(name = "joining_date")
  private Date joiningDate;

  @Column(name = "email_id", length = 50)
  private String emailId;

  @Column(name = "gender", length = 8)
  private String gender;

  @Column(name = "mob_number", nullable = false)
  private Long mobNumber;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "f_name", length = 50, nullable = true)
  private String fathersName;

  @Column(name = "m_name", length = 50, nullable = true)
  private String mothersName;

  @Column(name = "marrital_status", nullable = true)
  private String marritalStatus;

  @Column(name = "spouse_name", nullable = true)
  private String spouseName;

  @Column(name = "emp_id", nullable = false)
  private String empId;

  @Column(name = "personal_email", nullable = true)
  private String personalEmail;

  @Column(name = "designation", nullable = true)
  private String designation;

}
