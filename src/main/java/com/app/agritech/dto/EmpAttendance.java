package com.app.agritech.dto;

import lombok.Data;

@Data
public class EmpAttendance {

  String date;
  String loggedIn;
  String loggedOut;
  String attendance;
  String remark;

}
