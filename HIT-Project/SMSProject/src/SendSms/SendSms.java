package SendSms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class SendSms {

		public static void sendSms(String message,String number){
			try{
			
			String apiKey="<API Key>";
			String sendId="FSTSMS";
			//important step...
			message=URLEncoder.encode(message, "UTF-8");
			String language="english";
			
			String route="p";
			String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
			
			//sending get request using java..
			
			URL url=new URL(myUrl);
			HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
			
			
			con.setRequestMethod("GET");
//			
//			con.setRequestProperty("User-Agent", "Mozilla/5.0");
//			con.setRequestProperty("cache-control", "no-cache");
			System.out.println("Wait..............");
			
			int code=con.getResponseCode();
			
			System.out.println("Response code : "+code);
			
			StringBuffer response=new StringBuffer();
			
// 			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));//Review the Reponse of HttpsURLConnection //optional
			
// 			while(true){
// 				String line=br.readLine();
// 				if(line==null){
// 					break;
// 				}
// 				response.append(line);
// 			}
// 			System.out.println(response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
