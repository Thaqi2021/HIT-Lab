import java.util.*;

public class AreaTriangleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Base of Triangle:");
		Scanner sc = new Scanner(System.in);
		double b = sc.nextDouble();
		System.out.println("Enter the Width of Triangle:");
        double h = sc.nextDouble();
        double a = (b*h)/2;
        System.out.println("your Area of Triangle is "+a);
	}

}
