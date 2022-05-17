package com.email.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.api.entity.Email;
import com.email.api.services.EmailService;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping(value = "/sendMail")
	public String sendMail(@RequestBody Email email) {
		String status = emailService.sendEmail(email);
		return status;
	}

}
