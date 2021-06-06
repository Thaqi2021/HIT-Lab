
public class SwapTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first = 50;
		int second = 70;
		System.out.println("--Before swap--");
		System.out.println("First number = " + first);
		System.out.println("Second number = " + second);
		int temp =first;
		first = second;
		second = temp;
		System.out.println("--After swap--");
		System.out.println("First number = " + first);
	    System.out.println("Second number = " + second);
	}

}
