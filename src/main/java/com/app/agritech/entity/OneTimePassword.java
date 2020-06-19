package com.app.agritech.entity;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OneTimePassword {

  @Id
  long id;

  String otp;

  Instant createdDateTime;

  Instant expiredDateTime;

  Long userId;

  boolean expired;

}
