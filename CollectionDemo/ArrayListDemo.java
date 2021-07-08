package CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList<>();
		list.add("Thaqi");
		list.add(100);
		list.add(new Stone());
//		for(Object o:list) {
//			System.out.println(o);
//		}
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		ListIterator listIter=list.listIterator();
		while(listIter.hasNext()) {
			System.out.println(listIter.next());
		}
		while(listIter.hasPrevious()) {
			System.out.println(listIter.previous());
		}
	}

}
class Stone{
	
}