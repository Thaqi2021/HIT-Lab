package Lab2_1;

import java.util.Scanner;

public class Ladder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of Rows :");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		for(int i=1;i<=r;i++)
		 {
			for(int j=1;j<=i;j++)
					System.out.print(j);
			for(int k=i-1;k>=1;k--)
					System.out.print(k);
		 System.out.print("\n");
		}

	}

}
