package com.app.agritech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "description", length = 1000)
  private String description;

  @Column(name = "code", length = 100, nullable = false)
  private String code;

  @Column(name = "display_order")
  private Integer displayOrder;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "projectId")
  private Long projectId;

}
