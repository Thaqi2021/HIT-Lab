package hit.Lab_project;

public class ThreadRailway {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Thread t = Thread.currentThread();
		t.setName("muhaibeen");
		System.out.println("Reservation counter starting working..."+t.getName());
		ReservationCounter rc = new ReservationCounter();
		
		Thread Zaid = new Thread(new Booking(rc,1000),"Zaid");
		Thread Thaqi = new Thread(new Booking(rc,500),"Thaqi");
		Zaid.start();
		Thread.sleep(100);
		Thaqi.start();

	}

}
class Booking implements Runnable{
	ReservationCounter rc;int amt;
	public Booking(ReservationCounter rc,int amt) {
		this.rc=rc;
		this.amt=amt;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(rc){
		rc.giveAmount(amt);
		rc.returnAmount();
		}
	}

}
class ReservationCounter{
	int amt;
	void giveAmount(int amt) {
		Thread t=Thread.currentThread();
		this.amt=amt;
		String name=t.getName();
		System.out.println(name+" has come to book the ticket...");
		System.out.println(name+" brought...:"+amt);
		
	}
	void returnAmount() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Change given to...:"+name);
		System.out.println(name+" takes...:"+(amt-100));
	}
}
