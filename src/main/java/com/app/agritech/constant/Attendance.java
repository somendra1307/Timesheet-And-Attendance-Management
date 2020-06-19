package com.app.agritech.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Attendance {

  PRESENT("P", "Present"),
  ABSENT("A", "Absent"),
  WORK_FROM_HOME("WFH", "Work From Home"),
  LEAVE("L", "Leave");

  String code;

  String name;

}
