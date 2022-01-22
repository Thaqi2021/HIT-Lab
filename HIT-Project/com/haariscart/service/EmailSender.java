package com.haariscart.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailSender {
	public void welcomeUser();
	public void sendInvoice(String filePath) throws AddressException, MessagingException;
	public void verifyEmail();
}
