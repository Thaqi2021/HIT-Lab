package com.haariscart.service;

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
import org.springframework.web.multipart.MultipartFile;

import com.haariscart.model.HaariUser;


public class EmailSenderImpl implements EmailSender{
	Session newSession = null;
	MimeMessage mimemessage = null;
	String message="Welcome";
	
	@Autowired
	HaariUser user;
	
	@Override
	public void welcomeUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendInvoice(String Invoice) throws AddressException, MessagingException {
		String [] name =user.getEmail().split("@");
		 setupServerProperties();
		 message="Your Invoice is generated ./nYou can download your Invoice./nWe attached below./n Thanks for Shopping ";
	      draftEmail(name[0],user.getEmail(), Invoice);
	     sendEmail();
		
	}

	@Override
	public void verifyEmail() {
		// TODO Auto-generated method stub
		
	}

	void sendEmail() throws MessagingException {
		// TODO Auto-generated method stub
		 String fromUser ="haariscart.dean@gmail.com";                //"thaqifullstack@gmail.com";
		 String fromUserPassword = "pass**12";
		 String emailHost="smtp.gmail.com";
		 Transport transport = newSession.getTransport("smtp");
		 transport.connect(emailHost,fromUser,fromUserPassword);
		 transport.sendMessage(mimemessage, mimemessage.getAllRecipients());
		 transport.close();
		 System.out.println("\tEmail Sucessfully sent");
	}
	MimeMessage draftEmail(String name,String mailId,String filepath) throws AddressException,MessagingException{
    System.out.print("Sending Mail to "+name);
	String emailSubject ="Report card from Haaris Infotech Student";
	String Signature ="<b style=\"color:red;\">Thanks & Regards</b><br>Mr Mohammed Thaqi<br>"
			+ "FullStack Development Trainee,<br>"
			+ "Haaris Infotech Pvt. Ltd.,<br>"
			+ "E-Mail:haariscart.dean@gmail.com,<br>"
			+ "Customer Care: +917845014181.";
	String emailBody="Dear Mr/Mrs "+name+ ""
			+message
			+".<br> We attached Excel File<br><br>"+Signature;
	
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
	 void setupServerProperties() {
			Properties properties = new Properties();
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable","true");
			newSession = Session.getDefaultInstance(properties,null);
			
		}

}
