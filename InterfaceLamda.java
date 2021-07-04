package Lab2;

public class InterfaceLamda {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		Developer dev=()->{
			System.out.println("Developer is working.......");
		};
		dev.deve();
		Driver driver=(String s)->{
			System.out.println("The driver logic iss....");
			System.out.println("The value supplied is...:"+s);
		};
		
		driver.drive("the light machine..");
		
		Pilot pilot=(name,speed)->{
			System.out.println("The pilot name is...:"+name);
			System.out.println("The speed is...:"+speed);
		};
		pilot.fly("kranthi",1000);
//		oil l = new oil();
//		l.oily("Mehdiya", "Eamir", 10000);
		gamer game = new gamer();
		game.horn();
		//i used Expression scope for interface
		Labour lb = new InterfaceLamda()::hardly;
		lb.merci();
		//i used Expression scope for interface with two parameter
		mercifull mf = new InterfaceLamda()::easyway;
		mf.fully("Namaz", 100000);
	}
	public void hardly(){
		System.out.println("im working hard method is called..");
	}
	public void easyway(String s,int i) {
		System.out.println("Easy way is to be peace is "+s);
		System.out.println("No of Scientist in world "+i);

	}
}
interface Labour{
	void merci();
}
interface mercifull{
	void fully(String s,int i);
}
interface Driver{
	public void drive(String s);
}
interface Pilot{
	public void fly(String name,int speed);
}
interface Developer{
	public void deve();
}
class gamer {
	Driver d =(String d)->{
		System.out.println("in game my car name.."+d);
	};
	
	void horn() throws Exception{
	horror hr =(horror)Class.forName("Lab2.devil").newInstance();
	d.drive("cargo");

	}
}
abstract class horror{
	
}
class devil extends horror{
	public devil(){
		System.out.println("devil method called.....");
	}
	
}
// class oil implements Driver,Pilot,Developer{
//	void oily(String s,String a ,int i) {
//		deve();
//		fly(s,i);
//		drive(a);
//	}
//
//	@Override
//	public void deve() {
//		// TODO Auto-generated method stub
//		System.out.println("Yes im Excellent Developer...");
//		
//	}
//
//	@Override
//	public void fly(String name, int speed) {
//		// TODO Auto-generated method stub
//		System.out.println("filght name.."+name+"\nFilght Speed..."+speed);
//		
//	}
//
//	@Override
//	public void drive(String s) {
//		// TODO Auto-generated method stub
//		System.out.println("Then i used drive is "+s);
//	}
//}
//
//
//
//
