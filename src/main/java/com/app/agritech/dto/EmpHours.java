package com.app.agritech.dto;

import lombok.Data;

@Data
public class EmpHours {

  String task;
  String date;
  byte duration;
  String client;
  String project;
  String description;
  String issueTrackingId;

}
