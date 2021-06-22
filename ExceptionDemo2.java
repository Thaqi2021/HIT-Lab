package Lab2_1;

import java.util.Scanner;

public class ExceptionDemo2 {

	public static void main(String[] args) {

			Item it = new Stone();
			try {
			it.execute();
			}
			catch(Exception e) {
				System.out.println("Exception Occurs......"+e);
			
		}
	}
}
	abstract class DogExceptions extends Exception{
	}
	class DogBiteException extends DogExceptions{
		String msg;
		public DogBiteException(String msg) {
			this.msg=msg;
		}
		@Override
		public String toString() {
			return this.msg;
		}
	}
	class DogBarkException extends DogExceptions{
		String msg;
		public DogBarkException(String msg) {
			this.msg=msg;
		}
		@Override
		public String toString() {
			return this.msg;
		}
	}
	abstract class Item{
		public abstract void execute()throws DogExceptions;
	}
	class Stick extends Item{
		@Override
		public void execute() throws DogExceptions {
			throw new DogBiteException("You beat I bite.....");
		}
	}
	class Stone extends Item{
		@Override
		public void execute() throws DogExceptions {
			throw new DogBarkException("you hit I bark.........");
		}
	}
//	class Dog{
//		public void play(Item it) throws DogExceptions{
//			item.execute();
//		}
//	}
//	class Child{
//		public void playWithDog(Dog d,Item it) {
//			try {
//				d.play(it);
//			}catch(DogExceptions de) {
//				System.out.println(de);
//			}
//		}
//	}
