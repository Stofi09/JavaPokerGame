package com.web.socket.websocket.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailService {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("&{Spring.mail.username}")
	private String MESSAGE_FROM;
	
	private String MESSAGE_TO;
	
	
	@Autowired
	public void setJavaMailSender(JavaMailSender jms) {
		this.javaMailSender = jms;
	}
	 
	public void sendMessage(String mail, String name) {
		SimpleMailMessage message = null;
		try {
			MESSAGE_TO = mail;
			message = new SimpleMailMessage();
			message.setFrom(MESSAGE_FROM);
			message.setTo(MESSAGE_TO);
			message.setSubject("Confirmation");
			message.setText("Dear "+name+"! \n \nThank you, for using this feature!");
			javaMailSender.send(message);
		}catch (Exception e){
				e.printStackTrace();
		}
	}
}
