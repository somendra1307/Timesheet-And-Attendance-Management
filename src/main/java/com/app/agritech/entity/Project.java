package com.app.agritech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "code", length = 1000)
  private String code;

  @Column(name = "name", length = 1000)
  private String name;

  @Column(name = "description", length = 1000)
  private String description;

  @Column(name = "clientSupported")
  private boolean clientSupported;

}