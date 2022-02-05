package com.haaris.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Service;

public interface EmailSender {
	public void welcomeUser(String email );
	public void sendInvoice(String email ,String filePath) throws AddressException, MessagingException;
	public void verifyEmail(String email );
}
