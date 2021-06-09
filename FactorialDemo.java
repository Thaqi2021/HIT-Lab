import java.util.*;

public class FactorialDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to fact :");
		int n = sc.nextInt();
		int fact =1 ;
		while(0<n) {
			fact *=n;
			n--;
		}
		System.out.println(fact);

	}

}
