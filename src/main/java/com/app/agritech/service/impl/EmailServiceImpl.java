package com.app.agritech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.agritech.messaging.EmailData;
import com.app.agritech.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

  @Autowired
  public JavaMailSender emailSender;

  @Override
  public void sendEmail(EmailData emailData) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(emailData.getTo());
    message.setSubject(emailData.getSubject());
    message.setText(emailData.getTemplate());
    try {
      emailSender.send(message);
    } catch (MailException e) {
      e.printStackTrace();
    }
  }

}
