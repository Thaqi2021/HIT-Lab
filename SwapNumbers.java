
public class SwapNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int first = 98;
      int second = 81;
      
      System.out.println("--Before swap--");
      System.out.println("First number = " + first);
      System.out.println("Second number = " + second);
      first = first - second;
      second = first + second;
      first = second - first;
      System.out.println("--After swap--");
      System.out.println("First number = " + first);
      System.out.println("Second number = " + second);
	}

}
