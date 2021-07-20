package SoftwareEmailMarketing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

public class EmailSender {
	void emailRecipiens() throws IOException, AddressException, MessagingException{
		EmailSender mail1 = new  EmailSender();
		
//		Map<String ,String> hm = new HashMap();
//		hm.put("zaidmje@gmail.com", "https://github.com/MohammedZaidJ/HIT-lab");
//		hm.put("thaqicm@gmail.com", "https://github.com/Thaqi2021/HIT-Lab");
		
		FileInputStream fis = new FileInputStream("E://HIT//Email Project//src//SoftwareEmailMarketing//MailLink.Properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		Map<String, String> hm = (Map)prop;   //optional way of calling data
		for (Map.Entry<String,String> me : hm.entrySet()) {
        	String mail = (String) me.getKey();
			String[] name= mail.split("@");
			String name1= name[0];
			if(mail.contains("@")) {
			System.out.print("Sending mail to "+name1);
			String  mailid1 = me.getKey();
			String gitlink= me.getValue();
			mail1.setupServerProperties();
			mail1.draftEmail(name1,gitlink,mailid1);
			mail1.sendEmail();
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			}
			else {
				System.out.println("InValid Email id found :"+mail);
			}
		}
	}
	Session newSession = null;
	MimeMessage mimemessage = null;
	void sendEmail() throws MessagingException {
		 String fromUser ="thaqifullstack@gmail.com";
		 String fromUserPassword = "pass****";
		 String emailHost="smtp.gmail.com";
		 Transport transport = newSession.getTransport("smtp");
		 transport.connect(emailHost,fromUser,fromUserPassword);
		 transport.sendMessage(mimemessage, mimemessage.getAllRecipients());
		 transport.close();
		 System.out.println("\tEmail Sucessfully sent");
	}

	MimeMessage draftEmail(String name, String gitLink, String mailId) throws AddressException,MessagingException{
		
		String emailSubject ="A quick hello & congrats on the joining the HIT Team!";
		String Signature ="<b style=\"color:red;\">Thanks & Regards</b><br>Mr Mohammed Thaqi<br>"
				+ "FullStack Development Trainee,<br>"
				+ "Haaris Infotech Pvt. Ltd.,<br>"
				+ "E-Mail:thaqi.fullstack@gmail.com,<br>"
				+ "Phone: +917845014181.";
		String emailBody="Dear Mr/Mrs "+name+ "<br><br>To Know More Of Your Account : "+ "<a href="+gitLink+"/>"+gitLink+"</a><br><br>"+Signature;
		
		mimemessage = new MimeMessage(newSession);

		mimemessage.addRecipient(Message.RecipientType.TO,new InternetAddress(mailId));	
		mimemessage.setSubject(emailSubject);
		MimeBodyPart bodypart = new MimeBodyPart();
		bodypart.setContent(emailBody,"text/html");
		
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodypart); 
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
