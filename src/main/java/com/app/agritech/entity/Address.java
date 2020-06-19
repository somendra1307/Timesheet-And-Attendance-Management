package com.app.agritech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "address_text", length = 700, nullable = false)
  private String addressText;

  @Column(name = "city", length = 500)
  private String city;

  @Column(name = "country", length = 50)
  private String country;

  @Column(name = "district", length = 100)
  private String district;

  @Column(name = "lattitude")
  private long lattitude;

  @Column(name = "longitude")
  private long longitude;

  @Column(name = "pincode", nullable = false)
  private int pincode;

  @Column(name = "state", length = 50, nullable = false)
  private String state;

  @Column(name = "addressType", length = 50, nullable = false)
  private String addressType;

}
