package Lab2_1;
import java.util.Random;
import java.util.Scanner;

public class Rock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = 1;  
		int max = 10;  
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number 1 to 10:");
		int n = sc.nextInt();
		int b = (int)(Math.random()*(max-min+1)+min);  
		System.out.println("Random Number:"+b);
		int x = n+b;
		if(n==b) {
			System.out.println("You Won Iphone !!");
		}
		else if(x==n+1){
			System.out.println("Random Number is in bond:"+x);
			System.out.println("you Won Mac Laptop");
		}
		else {
			System.out.println("Sorry Next Try...!!!!");
		}


	}

}
