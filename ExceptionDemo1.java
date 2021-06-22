package Lab2_1;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATMUser atm = new ATMUser();
		try {
		atm.process("invalid");
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
class ATMUser {
	public void process(String card) throws InvalidCardDemo {
		if(card.equals("valid")){
			System.out.println("Card is processing");
		}
		else {
			throw new InvalidCardDemo("You have inserted a invalid card....");	

		}
				
		
	}
}
class InvalidCardDemo extends Exception{
	String msg;
	public InvalidCardDemo(	String msg) {
	this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception is..:"+msg;
	}
	
}