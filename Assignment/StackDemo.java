package DataStructure;

public class StackDemo {

	public static void main(String[] args) {
		Stack sk = new Stack();
		sk.push(10);
		sk.push(20);
		sk.push(30);
		sk.push(40);
		System.out.println(sk.pop());
	}
}	
class Stack{
	int s[] = new int[10];
	int tos;
	Stack(){
		tos = -1;
	}
	void push(int item) {
		if(tos==9)
			System.out.println("Stack is full....");
		else
			s[++tos]=item;
	}
	int pop() {
		if(tos>=0) {
			return s[tos--];
		}
		else {
			System.out.println("Stack is empty");
			return -1;
		}
	}
}
