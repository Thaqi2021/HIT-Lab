package SoftwareEmailMarketing;

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


public class MailSend {

	Session newSession = null;
	MimeMessage mimemessage = null;
	public static void main(String[] args) throws AddressException, MessagingException {

		EmailSender ar = new EmailSender();
		try {
			ar.emailRecipiens();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void sendEmail() throws MessagingException {
		 String fromUser ="thaqifullstack@gmail.com";
		 String fromUserPassword = "password";
		 String emailHost="smtp.gmail.com";
		 Transport transport = newSession.getTransport("smtp");
		 transport.connect(emailHost,fromUser,fromUserPassword);
		 transport.sendMessage(mimemessage, mimemessage.getAllRecipients());
		 transport.close();
		 System.out.println("\tEmail Sucessfully sent");
	}

	MimeMessage draftEmail(String name, String gitLink, String mailId) throws AddressException,MessagingException{
		
		String emailSubject ="A quick hello & congrats on the joining the GitHub Team!";
		String Signature ="<b style=\"color:red;\">Thanks & Regards</b><br>Mr Mohammed Thaqi<br>"
				+ "FullStack Development Trainee,<br>"
				+ "Haaris Infotech Pvt. Ltd.,<br>"
				+ "E-Mail:thaqi.fullstack@gmail.com,<br>"
				+ "Phone: +917845014181.";
		String emailBody="Dear Mr/Mrs "+name+ "<br><br>To Know More Of Your Account  "+ "<a href="+gitLink+"/>"+gitLink+"</a><br><br>"+Signature;
		
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
