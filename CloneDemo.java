package Lab2;

public class CloneDemo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Knowledge kw = new Knowledge();
//		Knowledge kd = new Knowledge();
		Knowledge kd = kw.createClone();
		Knowledge kg = kw.createClone();

		kw.name="heellomkjsas";
		kd.name="gatais";
		kg.name="thaqi";
		kd.gamer("Aslam");
		kg.gamer("Thaqi,,,,");
		System.out.println("1st obj is called..."+kw.name);
		System.out.println("2nd heap is called.."+kd.name);
		System.out.println("3rd heap is called.. "+kg.name);


	}

}
class Knowledge implements Cloneable{
	Knowledge(){
		System.out.println("obj is called.........");
	}
	String name ;
	int age;
	public Knowledge createClone() {
		try {
			return (Knowledge)super.clone();
		}
		catch(CloneNotSupportedException cne) {
			cne.printStackTrace();
			return null;
		}
	}
	void gamer(String name) {
		System.out.println("Name of Gamer"+name);
	}
	
}