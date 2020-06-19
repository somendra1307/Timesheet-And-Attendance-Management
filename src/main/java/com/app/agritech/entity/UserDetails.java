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
@Table(name = "user_details")
@Data
public class UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "last_login_date")
  private Date lastLogInDate;

  @Column(name = "logged_in")
  private boolean loggedIn;

  @Column(name = "password", length = 15, nullable = false)
  private String password;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "personal_detail_id")
  private PersonalDetails personalDetails;

  @Column(name = "role_code")
  private Integer roleCode;

  @Column(name = "email_id")
  private String emailId;

}
