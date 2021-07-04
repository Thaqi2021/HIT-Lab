package hit.Challenges;


public class ClassLevelLock {

	public static void main(String[] args) {
		MultiApartment aprt = new MultiApartment();
		MultiApartment aprt2 = new MultiApartment();//Object lock can't handles two or more class object to be synchronized
		Thread rainbow = new Thread(aprt,"RaibowAprt");
		Thread Ruby = new Thread(aprt2,"RubyAprt");
		rainbow.start();
		Ruby.start();
	}
}
class MultiApartment implements Runnable{
	Construction con = new Construction();
	@Override
	public void run() {
		Construction.bulid();//class lock
		Construction.basicWork();
		con.constructionOver();

	}
	
}
class Construction{
	public static synchronized void bulid() {//class lock
			for(int i =0;i<5;i++) {
				System.out.println("floor "+i+" Apartment Name: "+Thread.currentThread().getName());
				try{Thread.sleep(1000);}catch(Exception e) {};
			}
		}
	public static synchronized void basicWork() {
		System.out.println("plumbering,electric,.....etc ..completed..."+Thread.currentThread().getName());
	}

	public static synchronized void constructionOver() {
		System.out.println("construction over...."+Thread.currentThread().getName());
	}

		
}
