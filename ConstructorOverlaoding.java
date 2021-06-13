package Lab2;

public class ConstructorOverlaoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cs c = new Cs(10,20);
		c.printData();
		System.out.println("values of addition :"+c.add(10, 20));
		System.out.println("values of addition of 3 prameter :"+c.add(20, 50, 60));

	}

}
class Cs {
	int p,q;
	Cs(){
		
	}
	public Cs(int x,int y) {
		this.p =x;
		this.q =y;
	}
	public void printData() {
		System.out.println("values of p : "+p+"\nvalues of q : "+q);
	}
	public int add(int i ,int j) {
		return (i+j);
	}
	public int add(int i ,int j,int k) {
		return (i+j+k);
	}
}
