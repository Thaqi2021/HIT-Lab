package CollectionDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class GernericDemo2 {

	public static void main(String[] args) {
		Ball ball=new Ball();
		Sky sky=new Sky();
		
		//Accept accept=new Accept();
		//accept.obj=sky;	
		//accept.process();
		
		RightAccept<Ball> raccept=new RightAccept<>();
		raccept.setT(ball);
		Ball b =raccept.getT();

		Sky sk = new Sky();
		sk.Col();
		
		RightAccept<Sky> raccept2=new RightAccept<>();
		raccept2.setT(sky);
		Sky s=raccept2.getT();
		
	}

}
class Sky{
	void Col() {
		List<String> list=new ArrayList<>(10);
		list.add("thaqi");
		list.add("zaid");
		System.out.println(list);
		list.add("Zaiyan");
		list.add("Faiz");
		list.add(2, "fairoze");
		System.out.println(list);
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println(list.add("yosuf"));
		System.out.println(list);
		
		List<String> list1 = new Vector();//vector Implemented
		list1.add("thaqi");
		list1.add("zaid");
		System.out.println(list1);
		list1.add("Zaiyan");
		list1.add("Faiz");
		list1.add(2, "fairoze");
		
		System.out.println(list1);
		ListIterator<String> lis = list1.listIterator();
		while(lis.hasNext()){
			System.out.println(lis.next());
		}
		list1.add("zaheer");
		System.out.println(list1);
	}
}
class Ball{
	
}
class RightAccept<T>{ //generic implemented
	T obj;
	public T getT() {
		return obj;
	}
	public void setT(T obj) {
		this.obj=obj;
		System.out.println("Generic "+obj);
	}
}
//class Accept {
//	Object obj;
//	void process() {
//		if(obj instanceof Sky) {
//		     Sky s = new Sky();
//		     System.out.println(s);
//		     
//		}
//		if(obj instanceof Ball) {
//		     Ball s = new Ball();
//		     System.out.println(s);
//		}
//	}
//}

