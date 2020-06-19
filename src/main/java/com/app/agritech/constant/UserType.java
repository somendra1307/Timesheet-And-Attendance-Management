package com.app.agritech.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserType {

  ADMIN("admin", 1),
  NORMAL_USER("normal_user", 2);

  private String type;
  private int code;

}
