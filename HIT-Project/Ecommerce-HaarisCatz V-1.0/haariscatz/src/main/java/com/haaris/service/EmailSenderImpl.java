package com.haaris.service;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.haaris.model.HaariUser;

public class EmailSenderImpl implements EmailSender{
	Session newSession = null;
	MimeMessage mimemessage = null;
	String message="Welcome";
	String emailSubject ="HaarisCatz Admin";

	
	@Autowired
	HaariUser user;
	
	@Override
	public void welcomeUser(String email ) {
		message=" <br>Welcome to HaarisCatz Pvt ltd .<br> Enjoy Shopping from Home.<br><br>We Integrate only Quality Product"
				+ "<br>We Trust in Customer Satisfaction  <br> Enjoy Quality World";
		String logo ="E:\\HIT-Spring\\haariscatz\\src\\main\\resources\\invoice_logo.png";
		 try {
				mailSetup(email, logo);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	}
	
	private void mailSetup(String email,String Invoice) throws AddressException, MessagingException {
		String nemail=email;
		String [] name =nemail.split("@");
		setupServerProperties();
		draftEmail(name[0],email, Invoice);
	    sendEmail();
	}

	@Override
	public void sendInvoice(String email ,String Invoice){
		
		 message="<br>Your Invoice is generated .<br><br>You can download your Invoice.<br><br>We attached below./n <br>Thanks for Shopping ";
		 try {
			mailSetup(email, Invoice);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void verifyEmail(String email ) {
		String logo ="E:\\HIT-Spring\\haariscatz\\src\\main\\resources\\invoice_logo.png";
		 try {
				mailSetup(email, logo);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		
	}

	private void sendEmail() throws MessagingException {
		// TODO Auto-generated method stub
		 String fromUser ="haariscart.dean@gmail.com";                //"thaqifullstack@gmail.com";
		 String fromUserPassword = "pass***1";
		 String emailHost="smtp.gmail.com";
		 Transport transport = newSession.getTransport("smtp");
		 transport.connect(emailHost,fromUser,fromUserPassword);
		 transport.sendMessage(mimemessage, mimemessage.getAllRecipients());
		 transport.close();
		 System.out.println("\tEmail Sucessfully sent");
	}
	private MimeMessage draftEmail(String name,String mailId,String filepath) throws AddressException,MessagingException{
    System.out.print("Sending Mail to "+name);
	String Signature ="<b style=\"color:red;\">Thanks & Regards</b><br>Mr Mohammed Thaqi<br>"
			+ "FullStack Development Trainee,<br>"
			+ "Haaris Infotech Pvt. Ltd.,<br>"
			+ "E-Mail:haariscart.dean@gmail.com,<br>"
			+ "Customer Care: +917845014181.";
	String emailBody="Dear Mr/Mrs "+name+ ""
			+message
			+".<br><br>WE THINK QUALITY .WE INTEGERATE QUALITY.WE THINK FOR CUSTOMERS <br><br>"+Signature;
	
	mimemessage = new MimeMessage(newSession);

	mimemessage.addRecipient(Message.RecipientType.TO,new InternetAddress(mailId));	
	mimemessage.setSubject(emailSubject);

	MimeBodyPart filedd = new MimeBodyPart();//attachment to mail
//	MimeBodyPart filedd2 = new MimeBodyPart();
	try {
		File file = new File(filepath);
		filedd.attachFile(file);
//		File file2 = new File(cpath);
//		filedd2.attachFile(file2);
	} catch (IOException e) {
		e.printStackTrace();
	} catch (MessagingException e) {
		e.printStackTrace();
	}
	MimeBodyPart bodypart = new MimeBodyPart();
	bodypart.setContent(emailBody,"text/html");
	
	MimeMultipart multipart = new MimeMultipart();
	multipart.addBodyPart(bodypart); 
	multipart.addBodyPart(filedd);
//	multipart.addBodyPart(filedd2);

	mimemessage .setContent(multipart);
	return mimemessage;

	}
	private void setupServerProperties() {
			Properties properties = new Properties();
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable","true");
			newSession = Session.getDefaultInstance(properties,null);
			
		}

}
