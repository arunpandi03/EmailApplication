package com.example.EmailApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmailApplication.entity.EmailDetails;
import com.example.EmailApplication.service.EmailService;

@RestController
@RequestMapping("/api")
public class EmailController {
	
	
	@Autowired 
private EmailService emailService;
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails emailDetails) {
		String status = emailService.sendSimpleMail(emailDetails);
		return status;
	}
	
	
	@PostMapping("/sendMailWithAttachment")
	public String SendMailWithAttachment(@RequestBody EmailDetails emailDetails) {
		String status = emailService.SendMailWithAttachment(emailDetails);
		return status;
	}
	
	
	
	}


