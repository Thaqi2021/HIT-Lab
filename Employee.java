package Lab2;

public class Employee {
	int empid;
	String empName;
	Employee(int id ,String name){
		this.empid =id;
		this.empName =name;
	}
	void info() {
		System.out.println("Id: "+empid+"\nName :"+empName);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee(21176,"Thaqi");
		emp.info();

	}

}
