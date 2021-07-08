package CollectionDemo;

public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paint p = new GreenPaint();
		Paint pr = new RedPaint();

		Cleaning c = new Mirror();

		PaintBrush<Paint> pb = new PaintBrush<>();//specific collection of calling generic
		pb.obj=p;	
		pb.setObj(p);
		pb.getObj();
		Paint mypaint=pb.getObj();
		mypaint.dopaint();
		
		PaintBrush<Paint> pbr = new PaintBrush<>();//specific collection of calling generic
		pbr.setObj(pr);
		pbr.getObj().dopaint();
		
		
		
		PaintBrush<Cleaning> pf = new PaintBrush<>();
		pf.obj =c;
		pf.setObj(c);
		pf.getObj();
		Cleaning cln = pf.getObj();
		cln.clean();
//		
//		PaintBrush pb = new PaintBrush();
//		pb.obj=c;
//		pb.doPaint();
		
		
		// instance of Integer type
		Test <Integer> iObj = new Test<Integer>(15);
		System.out.println(iObj.getObject());

		// instance of String type
		Test <String> sObj =new Test<String>("GeeksForGeeks");
		System.out.println(sObj.getObject());

	}

}
abstract class Paint{
	abstract void dopaint();
}
class RedPaint extends Paint{
	RedPaint(){
		System.out.println("Im Color Red....");
	}
	@Override
	void dopaint() {
		System.out.println("Red Colour.....");
	}
	
}
class GreenPaint extends Paint{
	GreenPaint(){
		System.out.println("Im Color Green......");
	}
	@Override
	public void dopaint() {
		System.out.println("Green Colour.....");
	}
	
}
abstract class Cleaning{
	public abstract void clean();
}
class Kitchen extends Cleaning{
	@Override
	public void clean() {
		System.out.println("Cleaning Kitchen......");		
	}
	
}
class Mirror extends Cleaning{

	@Override
	public void clean() {
		System.out.println("Cleaning Mirror......");		
		
	}
	
}
class PaintBrush<T>{  //generic implements in this class 
	T obj;
	public void setObj(T obj) {
		this.obj=obj;
	}
	public T getObj() {
		return this.obj;
	}

}
//class PaintBrush{
//	Object obj;
//	void doPaint() {
//		if(obj instanceof Paint) {
//			Paint paint=(Paint)obj;
//			paint.dopaint();
//		}
//		if(obj instanceof Cleaning) {
//			Cleaning makeup=(Cleaning)obj;
//			makeup.clean();
//		}
//	}
//}

class Test<T> //implemented generic 
{
	// An object of type T is declared
	T obj;
	Test(T obj) { 
    this.obj = obj; 
    } // constructor
	public T getObject() { return this.obj; }
}
