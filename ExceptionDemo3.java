package Lab2_1;

public class ExceptionDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee emp = new Fulltime();
		try {
		emp.salary();
		}
		catch(Exception e) {
			System.out.println("Exception is ..."+e);
		}

	}

}
abstract class Unpaid  extends Exception{
	
}
class FullUnpaid extends Unpaid{
	String msg;
	FullUnpaid(String s){
		msg=s;
	}
	public String toString() {
		return msg;
	}
	
}
class PartUnpaid extends Unpaid{
	String msg;
	PartUnpaid(String s){
		msg=s;
	}
	public String toString() {
		return msg;
	}
}
abstract class Employee extends Unpaid {
	abstract void salary() throws Unpaid;
}
class Fulltime extends Employee{
	void salary() throws Unpaid {
		throw new FullUnpaid("Company didn't Paid the Full PAY.....");
	}
}
class PartTime extends Employee{
	void salary() throws Unpaid {
		throw new PartUnpaid("company didn't paid the part pay too.... ");
		
	}
}
class solution{
	void solution(Employee emp) {
		try {
		emp.salary();
		}
		catch(Exception e) {
			System.out.println("Exception occurs......"+e);
		}
	}
}