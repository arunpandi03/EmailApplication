package com.example.EmailApplication.serviceImpl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.EmailApplication.entity.EmailDetails;
import com.example.EmailApplication.service.EmailService;

import jakarta.mail.internet.MimeMessage;
@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired 
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") 
	private String sender;

	@Override
	public String sendSimpleMail(EmailDetails emailDetails) {
		try {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(sender);
		mailMessage.setTo(emailDetails.getRecipient());
		mailMessage.setSubject(emailDetails.getSubject());
		mailMessage.setText(emailDetails.getMessageBody());
		
		javaMailSender.send(mailMessage);
		return "Mail sent Successfully...\n\n Mail Details:"
				+"\nSender:"+sender 
				+ "\nrecipient:"+emailDetails.getRecipient()
				+ "\nsubject: "+emailDetails.getSubject()
				+"\nmessageBody:"+emailDetails.getMessageBody();
	}
	catch(Throwable e) {
		 e.printStackTrace();
		return "Oops! Something went wrong while send.try again!";
	}
	
	}

	@Override
	public String SendMailWithAttachment(EmailDetails emailDetails) {
	MimeMessage mimeMessage =  javaMailSender.createMimeMessage();
	MimeMessageHelper mimeMessageHelper;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setText(emailDetails.getMessageBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            
            FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
            mimeMessageHelper.addAttachment(file.getFilename(), file);
            
            javaMailSender.send(mimeMessage);
            return "Your Mail has been sent Successfully...!";
		}
		catch(Throwable e) {
			 e.printStackTrace();
			return "Oops! Something went wrong while send.try again!";
		}
		
		
	}
}
