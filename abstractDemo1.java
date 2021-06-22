package Lab2_1;

public class abstractDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time ft = new Time();
		ft.time();
		ft.salary();

	}

}
abstract class demo{
	abstract void salary();
}
class Part extends demo{
	void salary() {
		int p = 5000;
		System.out.println(p+" per month Part time");
	}
}
class Full extends demo{
	void salary() {
		int f = 25000;
		System.out.println(f+"per month FullTime");
	}
}
class Time extends Full{
	void time() {
		System.out.println("FullTime 8 hours");
	}
}