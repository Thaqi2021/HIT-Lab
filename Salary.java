package Lab2;
import java.util.*;
import java.text.*;
public class Salary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double currentsalary;
		double raise;
		double newsalary;
		String rating;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the salary :");
		currentsalary = sc.nextDouble();
		
		System.out.println("Enter perfornance rating \n(Excellent,Good, or Poor)");
        rating = sc.next();
        
        if(rating.equals("Excellent")) {
        	raise = (currentsalary/100)*6;
        }
        else if(rating.equals("Good")) {
        	raise = (currentsalary/100)*4;
        }
        else {
        	raise = 0;
        }
        sc.close();
        newsalary = currentsalary + raise; 
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println();
        System.out.println("Current Salary :"+money.format(currentsalary));
        System.out.println("Amount of your raise: "+money.format(raise));
        System.out.println("your new salary: "+money.format(newsalary));
        System.out.println();

        
	}

}
