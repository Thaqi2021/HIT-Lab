package CollectionDemo;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeSet<String> ts = new TreeSet<>(new Mycompare()); //calling through the class

		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() { //calling interface in it to compare which is known as method Expression
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		ts.add("Thaqi");
		ts.add("Mehdi");
		ts.add("Apple");
		ts.add("Zaitoon");
		System.out.println(ts);
		
	}

}
class Mycompare implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);
	}

	
	
}