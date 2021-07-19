package SoftwareEmailMarketing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class EmailSender {
	void emailRecipiens() throws IOException, AddressException, MessagingException{
		MailSend mail1 = new  MailSend();
		
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

}
