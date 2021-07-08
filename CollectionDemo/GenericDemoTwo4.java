package CollectionDemo;

import java.util.ArrayList;
import java.util.List;

public class GenericDemoTwo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Room <String,Integer> rm = new Room<String,Integer>();
		rm.attend("C Md Thaqi", 21176);
		rm.attend("Zaid", 21255);
		
		Integer [] Num = {100,200,600,700};
		String [] word = {"Apple","Mango","Fig","Pineapple","Orange"};
		Character [] alp ={'N','E','W', 'C','L','G'};
		System.out.println("Print the Number from array");
		printArray(Num);
		
		System.out.println("Print the String from Array");
		printArray(word);
		
		System.out.println("Print the Character from Array");
		printArray(alp);
		
		Listing lst = new Listing();
		lst.List();
		
	}
	static public <T> void printArray(T[]inputArray){  //calling Generic in Method
		for(Object T:inputArray) {
			System.out.print(T+" ");
		}
		System.out.println();
	}

}
class Room<T1,T2>{ //Calling Two Types in One class
	void attend(T1 var1,T2 var2) {
		System.out.println("Name :"+var1+"\nID :"+var2);
	}
}
class Listing{
	void List() {
		List<String> list = new ArrayList<>(); //  List is used Specific Generic of its Type
		list.add("MD Zaiyan");
		
		System.out.println("Number of Integer List :"+list);
		double a = 9.78f;
	    int myInt = (int) a;//manual Type Casting
	    System.out.println("Double :"+a +" = Change to Int :"+myInt);
	}
}