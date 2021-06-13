package Lab2;

public class Student {
	String name,city;
	int age;
	static int roll;
	
	void printData() {
		System.out.println("Student name = "+name);
		System.out.println("Student city = "+city);
		System.out.println("Student age = "+age); 
		System.out.println("Student roll ="+roll);
		System.out.println("finish");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		Student s2 = new Student();
		s1.name = "Thaqi";
		s1.city = "mehdi";
		s1.age = 25;
		s2.name = "Zaid";
		s2.city = "mehdi";
		s2.age = 26;
		s1.roll = 21176;
		//s2.roll = 21255;
		s1.printData();
		s2.roll = 21255;
		s2.printData();
		
		System.out.println("main roll :"+Student.roll);

	}

}
