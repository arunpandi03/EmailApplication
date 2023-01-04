package com.example.EmailApplication.service;

import com.example.EmailApplication.entity.EmailDetails;

public interface EmailService {

	String sendSimpleMail(EmailDetails emailDetails);

	String SendMailWithAttachment(EmailDetails emailDetails);

}
