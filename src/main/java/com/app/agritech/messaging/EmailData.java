package com.app.agritech.messaging;

import java.util.Map;

import lombok.Data;

@Data
public class EmailData {

  String subject;

  String template;

  Map<String, String> templateValues;

  String[] to;

  String[] cc;

  String[] bcc;

}
