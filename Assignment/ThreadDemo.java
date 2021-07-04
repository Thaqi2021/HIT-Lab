package hit.Assignment;


public class ThreadDemo {

	public static void main(String[] args) {
		fav f = new fav();
		Thread fav = new Thread(f,"favourate");//normal way of calling Thread
		fav.setName("ate ");
		fav.setPriority(5);
		fav.start();
		
		 Thread t = new Thread(){  //anonymous class
	            public void run(){
	            	Thread.currentThread().setName("zaid");
	                System.out.println("Child Thread "+Thread.currentThread().getName());
	            }
	      };
	      t.start();
	      System.out.println("Main Thread "+Thread.currentThread().getName());        
	}
}
class fav implements Runnable{

	@Override
	public void run() {
		String t = Thread.currentThread().getName();
		System.out.println("favourate child Thread........."+t);		
	}
	
}
