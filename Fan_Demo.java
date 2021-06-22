package Lab2_1;

import java.util.Scanner;

public class Fan_Demo {
	public static void main(String[] args) {
		GoodFan gf = new GoodFan();
		Scanner sc = new Scanner(System.in);
        while(true) {
        	System.out.println("Increase the Speed Of Fan:..........");
        	sc.next();
        	gf.Run();     	
        }
	}

}
class GoodFan{
	Fan stage= new Fan();
	void Run() {
		stage.Run(this);
	}
}
class Fan  {
	void Run(GoodFan f) {
		System.out.println("Fan is on......");
		f.stage = new Fan_speed_1();
	}
	
}
class Fan_speed_1 extends Fan{
	void Run(GoodFan f){
		System.out.println("Fan is Running in Speed 1....");
		f.stage = new Fan_speed_2();

	}
	
}
class Fan_speed_2 extends Fan{
	void Run(GoodFan f){
		System.out.println("Fan is Running in Speed 2....");
		f.stage = new Fan_speed_3();
	}
	
}
class Fan_speed_3 extends Fan{
	void Run(GoodFan f){
		System.out.println("Fan is Running in Speed 3....");
		f.stage = new Fan_off();
	}
}
class Fan_off extends Fan{
	void Run(GoodFan f){
		System.out.println("Fan is Off....");
		f.stage = new Fan();
	}
}
