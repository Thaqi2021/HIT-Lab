package Lab2;

public class InterfaceExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Healthy heal = new InterfaceExpression()::cycling;
		heal.excersice();
		
		Foods food = new InterfaceExpression()::healthyeats;
		food.healthyfood();
		
		hygine hy = InterfaceExpression::beclean;
		hy.cleaness();

	}
	void cycling() {
		System.out.println("cycling is good for health...");
	}
	void healthyeats() {
		System.out.println("fuirts is good for health.....");
	}
	static void beclean() {
		System.out.println("cleaness is half of iman...");
	}
}
interface Healthy{
	void excersice();
}
interface Foods{
	void healthyfood();
}
interface hygine{
	void cleaness();
}