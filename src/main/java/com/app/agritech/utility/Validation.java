package com.app.agritech.utility;

public class Validation {

  public static boolean isNotNull(Object obj) {
    return obj != null;
  }

  public static boolean isNotEmpty(String obj) {
    return obj != null && !obj.trim().isEmpty();
  }

}
