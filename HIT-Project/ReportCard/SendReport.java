package ReportCard;

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

public class SendReport {
	Session newSession = null;
	MimeMessage mimemessage = null;
	void sendEmail() throws MessagingException {
		// TODO Auto-generated method stub
		 String fromUser ="thaqifullstack@gmail.com";
		 String fromUserPassword = "pass****";
		 String emailHost="smtp.gmail.com";
		 Transport transport = newSession.getTransport("smtp");
		 transport.connect(emailHost,fromUser,fromUserPassword);
		 transport.sendMessage(mimemessage, mimemessage.getAllRecipients());
		 transport.close();
		 System.out.println("\tEmail Sucessfully sent");
	}
	MimeMessage draftEmail(String name,String mailId,String filepath,String SName, String cpath) throws AddressException,MessagingException{
    System.out.print("Sending Mail to "+name);
	String emailSubject ="Report card from Haaris Infotech Student";
	String Signature ="<b style=\"color:red;\">Thanks & Regards</b><br>Mr Mohammed Thaqi<br>"
			+ "FullStack Development Trainee,<br>"
			+ "Haaris Infotech Pvt. Ltd.,<br>"
			+ "E-Mail:thaqi.fullstack@gmail.com,<br>"
			+ "Phone: +917845014181.";
	String emailBody="Dear Mr/Mrs "+name+ "<br><br>Result has been Published .<br>To Know the Result of Your Son/Daughter "+SName+".<br> We attached Excel File<br><br>"+Signature;
	
	mimemessage = new MimeMessage(newSession);

	mimemessage.addRecipient(Message.RecipientType.TO,new InternetAddress(mailId));	
	mimemessage.setSubject(emailSubject);

	MimeBodyPart filedd = new MimeBodyPart();//attachment to mail
	MimeBodyPart filedd2 = new MimeBodyPart();
	try {
		File file = new File(filepath);
		filedd.attachFile(file);
		File file2 = new File(cpath);
		filedd2.attachFile(file2);
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
	multipart.addBodyPart(filedd2);

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
