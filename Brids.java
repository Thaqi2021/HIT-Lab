package Lab2;

public class Brids {
	int age;
	String name;
	Brids(){
		System.out.println("This is the parrot");
	}
	Brids(String x){
		name=x;
		System.out.println("h...o my name "+name);
	}
	Brids(String x,int a){
		this.name=x;
		this.age=a;
		System.out.println("h...o my name:"+name+" and age: "+age);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Brids();
		new Brids("mito");
		new Brids("unito",23);

	}

}
