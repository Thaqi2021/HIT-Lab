import java.util.*;
public class LeapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Year to find Leap year :");
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String result =(l%4==0)?"yes "+l+" is leap year":"No "+l+" is not a leap year";
        System.out.println(result);
	}

}
