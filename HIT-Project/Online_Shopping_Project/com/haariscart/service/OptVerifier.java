package com.haariscart.service;

import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;
@Service
public class OptVerifier {
	String message="HaarisCart Pvt Ltd ";
	public String verifyMobileNo(long number) {
		int otp;
		String num =number+"";
		if(num.matches("\\d{10}")) {
			int min = 100000;  
			int max = 1000000;  
			otp = (int)(Math.random()*(max-min+1)+min);  
			System.out.println(num+" "+otp);
			String message = "Hi you are most welcome to Haaris Infotech \n Verify the Mobile Number using OPT :"+otp;
			sendSms(message , number);
			System.out.println("wait 2 mins...."); 
			return "success";

		}
		else {
			System.out.println("Enter valid number size 10");
		}
		return "s";
		
	}
	
	void sendSms(String mess,long num) {
		try{
		

		String apiKey="GMjNhRgyUiuLJ8d2KIOxYZST4s0pD6r9QtwPqbBolAvcnkm71fnTQhJtsYqF1E7kgylpWC63Uzdc52Rv";
		String sendId="FSTSMS";
		//important step...
		message ="HaarisCart Pvt Ltd .\n"+mess;
//		System.out.println(message);
		message=URLEncoder.encode(message, "UTF-8");
		String language="english";
		String number=num+"";
		String route="p";
		if(number.matches("\\d{10}")) { //validating Mobile Number

		String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
		
		//sending get request using java..
		
		URL url=new URL(myUrl);
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();			
		
		con.setRequestMethod("GET");
		System.out.println("Wait..............");
		
		int code=con.getResponseCode();
		
		System.out.println("Response code : "+code);
		}else{System.out.println("Invalid Number :"+number);}}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
