package com.app.agritech.service;

import com.app.agritech.messaging.EmailData;

public interface EmailService {

	void sendEmail(EmailData emailData);

}
