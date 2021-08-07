package ReportCard;

import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class SendSMS {
		void sendSms(String mess,long num) {
			try{
			String apiKey="<<API Key>>";
			String sendId="FSTSMS";
			//important step...
			String message ="Haaris Infotech Pvt Ltd .\nResult has been Published.\n"+mess;
//			System.out.println(message);
			message=URLEncoder.encode(message, "UTF-8");
			String language="english";
			String number=num+"";
			String route="p";
			String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
			
			//sending get request using java..
			
			URL url=new URL(myUrl);
			HttpsURLConnection con=(HttpsURLConnection)url.openConnection();			
			
			con.setRequestMethod("GET");
			System.out.println("Wait..............");
			
			int code=con.getResponseCode();
			
			System.out.println("Response code : "+code);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
