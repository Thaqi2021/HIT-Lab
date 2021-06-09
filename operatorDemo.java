import java.util.*;
public class operatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char operator;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Num1 :");
		int num1 = sc.nextInt();
		System.out.println("Enter the Num1 :");
		int num2 = sc.nextInt();
        int result;

		System.out.println("Enter the operator + ,* ,- ,/ :");
		operator = sc.next().charAt(0);
		switch(operator){
		case '+' : result= num1 + num2;
		           System.out.println("your Result is ready :"+result);
		break;
		case '-' : result= num1 + num2;
        	System.out.println("your Result is ready :"+result);
        break;
        case '*' : result= num1 + num2;
        	System.out.println("your Result is ready :"+result);
        break;
        case '/' : result= num1 + num2;
        	System.out.println("your Result is ready :"+result);
        break;
		}

	}

}
