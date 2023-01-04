package com.example.EmailApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
	private String recipient;
	private String subject;
	private String messageBody;
	private String attachment;

}
