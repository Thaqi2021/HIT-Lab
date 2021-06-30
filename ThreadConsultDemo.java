
public class ThreadConsultDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hall h = new hall();
        Thread Zaid = new Thread(new Consultancy(h),"zaid");
        Thread Thaqi = new Thread(new Consultancy(h),"Thaqi");
        Zaid.start();
        Thaqi.start();

	}

}
class Consultancy implements Runnable{
	hall h ;
	Consultancy(hall hl){
		this.h=hl;
	}
	@Override
	public void run() {
//			synchronized (h) {
				if(Thread.currentThread().getName().equals("zaid")) {
					try {
						h.table();
						h.table2();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if(Thread.currentThread().getName().equals("Thaqi")){
					h.water();
				}
//			}

		
	}
	
}
class hall{
	String name;
	synchronized public void table()throws Exception {
		System.out.println("table..Name:...."+Thread.currentThread().getName());
		Thread.sleep(5000);
	}
	synchronized public void table2() {
		System.out.println("table2.Name:....."+Thread.currentThread().getName());
	}
	public void water() {
		System.out.println("Water...."+Thread.currentThread().getName());
	}
}
