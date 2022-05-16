package com.email.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.email.api.entity.Email;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public String sendEmail(Email email )
	{
		
		try {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("jsparrow007.captain@gmail.com");
		message.setTo(email.getRecipient());
		message.setSubject(email.getSubject());
		message.setText(email.getMsgBody());
		javaMailSender.send(message);
		return "Notification Send Through Mail";

	}
		catch(Exception e) {
			return "Error while Sending Mail";
		}
	}

}
