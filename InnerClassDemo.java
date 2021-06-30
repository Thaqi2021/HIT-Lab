package hit.Lab_project;

import java.lang.reflect.Method;

public class InnerClassDemo {

	public static void main(String[] args) {
		Kali2 kalimark=new Kali2();
		kalimark.sellCola();
		
		Pepsi2 pepsico=new Pepsi2();
		pepsico.sellCola();
		
		MBBS ms = new MBBS();
		Doctor doctor1 =(Doctor)ms;
		doctor1.doCure();
		
		BUMS bs = new BUMS();
		Doctor doctor2 = (Doctor)bs;
		doctor2.doCure();
	}
}
interface Cola2{
	public void makeCola();
}
class Pepsi2{
	public void sellCola() {
		//if you want to access a inner class  -- below is the syntax
		//Kali2.CampaCola cc=new Kali2().new CampaCola();
		
		Cola2 ccc=new Kali2().thief();
		ccc.makeCola();
		System.out.println("Pepsi fills campa cola in pepsi bottle and sell..7\n");
	}
}
class Kali2{
	public void sellCola() {
		//local inner class - a class with in a method...
		//merging.... 1
		//merging 1 problem - The class called campacola is still existing..
		class CampaCola implements Cola2{//inner class
			@Override
			public void makeCola() {
				System.out.println("Cola made by campa cola...2");
			}
		}
		//Merging 2 - The class campa cola will be dissolved.
		//Strategy 1  - anonymous inner class
		new Cola2() {			
			@Override
			public void makeCola() {
				System.out.println("campa cola is made....1");
			}
		}.makeCola();
		CampaCola cc=new CampaCola();
		cc.makeCola();
		//Strategy 2 - Method Expression
		Cola2 ccx=new Kali2()::makeKaliCola;
		ccx.makeCola();
		
		//Strategy 3 - Lambda
		Cola2 ccc=()->{System.out.println("Cola made by campa cola....using lambda....4");};
		ccc.makeCola();
		System.out.println("kali fills campa cola in bovonto bottle and sell..5");
	}
	private void makeKaliCola() {
		System.out.println("cola made by kali using campa cola formula....3");
	}
	public Cola2 thief() {
		return new CampaCola();
	}
	//kalimark has acquired campacola...
	class CampaCola implements Cola2{//inner class
		@Override
		public void makeCola() {
			System.out.println("Cola made by campa cola...6");
		}
	}
}
interface Doctor{
	void doCure();
}
class MBBS implements Doctor{

	@Override
	public void doCure() {
		System.out.println("Getting Cure from MBBS..........1");
	}
	
}
class BUMS implements Doctor{

	@Override
	public void doCure() {
		System.out.println("Getting Cure from BUMS..........2");
		
	}
	
}