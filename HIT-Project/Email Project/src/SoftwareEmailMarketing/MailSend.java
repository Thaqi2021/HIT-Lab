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


	public static void main(String[] args) throws AddressException, MessagingException {

		EmailSender ar = new EmailSender();
		try {
			ar.emailRecipiens();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
