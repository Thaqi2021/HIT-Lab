package SendSms;

import java.util.Scanner;

public class OTPGenerator {
	private static int otp;

	public static void main(String[] args) {
		OTPGenerator otpg = new OTPGenerator();
		System.out.println("Enter Your Mobile Number :");
		Scanner sc = new Scanner(System.in);
		String num =sc.nextLine();
		if(num.matches("\\d{10}")) {
			int min = 100000;  
			int max = 1000000;  
			otp = (int)(Math.random()*(max-min+1)+min);  
			System.out.println(num+" "+otp);
			String message = "Hi you are most welcome to Haaris Infotech \n Verify the Mobile Number using OPT :"+otp;
			SendSms.sendSms(message , num);
			System.out.println("wait 2 mins...."); 
			otpg.verify();
		}
		else {
			System.out.println("Enter valid number size 10");
		}
		
	}
	void verify() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the OTP :");
		int otpm = sc.nextInt();
		if(otp==otpm) {
			System.out.println("Mobile Number is Verifed");
		}
		else {
			System.out.println("Try again...");
		}
	}
	
	
}
