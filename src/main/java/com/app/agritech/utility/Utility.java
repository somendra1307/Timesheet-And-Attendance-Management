package com.app.agritech.utility;

import java.util.Random;

public class Utility {

  private static final int OTP_LENGTH = 5;

  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  public static String generateOTP() {
    String otp = "";
    Random random = new Random();
    int range = CHARACTERS.length();
    for (int i = 0; i < OTP_LENGTH; i++) {
      int position = random.nextInt(range);
      otp += CHARACTERS.charAt(position);
    }
    return otp;
  }

}
