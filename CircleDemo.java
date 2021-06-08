import java.util.*;
public class CircleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //final double pi = 3.14;
        System.out.println("Enter the radius of Circle :");
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        double a = Math.PI*Math.pow(r, 2);
        System.out.println("your area of circle "+a);
	}

}
