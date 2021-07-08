package CollectionDemo;

public class GenericDemo3 {

	public static void main(String[] args) {
		Phone phn = new Games();
		BasicPhone bphn = new Calling();

		OS<Phone> os = new OS();
		os.os=phn;
		os.set(phn);
		os.get();
		Phone p = os.get();
		p.apps();
		
	}

}

abstract class Phone{
	abstract void apps();
}
class Games extends Phone{
	@Override
	void apps() {
		System.out.println("Playing games......");
	}
	
}
class SocialMedia extends Phone{
	@Override
	void apps() {
		System.out.println("Whatsapp is used connect with people......");
	}
	
}
abstract class BasicPhone{
	abstract void general();
}
class Calling extends BasicPhone{
	@Override
	void general() {
		System.out.println("Calling.....");
	}
	
}
class Message extends BasicPhone{
	@Override
	void general() {
		System.out.println("Messaging......");
	}
	
}
class OS<o>{
	o os;
	public o get() {
		return os;	
	}
	void set(o obj) {
		this.os=obj;
	}
}
