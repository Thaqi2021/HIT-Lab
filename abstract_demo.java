package Lab2_1;

public abstract class abstract_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		abbsdemo ab = new abbsdemo();
		chief c = new chief();
		c.demofun();
		ab.process();

	}
	abstract void life();
	void demofun() {
		System.out.println("Knowledge demofun is called .......");
	}

}
class abbsdemo extends abstract_demo{
	void life() {
		System.out.println("iqra iqra.......iqra");
	}
	void process(){
		try {
		abbsdemo ab = new abbsdemo();
		bbsdemo bb = new bbsdemo();
		ab.life();
		bb.life();
		int i =1/0;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
class bbsdemo {
	void life() {
		System.out.println("aalim ....aalim");
	}
}
class chief extends abbsdemo{
	
}