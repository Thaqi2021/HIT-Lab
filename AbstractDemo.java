package hit.Lab_project;

public class AbstractDemo {

	public static void main(String[] args) {
		
		Item iceCream=new Vanila(new Nuts(new DryFruit(new ButterScotch(new Vanila())) ));
		System.out.println("One Vanila cup..+ Nuts. + Butter Scotch:"+iceCream.cost());
	}

}
abstract class Item{
	public abstract int cost();
}
abstract class Cream extends Item{
	
}
abstract class Ingredients extends Item{
	
}
class Vanila extends Cream{//static binding - what cannot be changed at runtime
	Item item;
	public Vanila() {
		System.out.println("Vanila cons.......");
	}
	public Vanila(Item item) {// dynamic binding - at constructor level
		this.item=item;
		System.out.println(item+"........1");
	}
	@Override
	public int cost() {
		if(item==null) {
			return 10;
		}else {
			return 10+item.cost();
		}
			
	}
}
class ButterScotch extends Cream{
	Item item;
	public ButterScotch() {
		System.out.println("ButterScotch cons.......");
	}
	public ButterScotch(Item item) {
		this.item=item;
		System.out.println(item+"........2");

	}
	@Override
	public int cost() {
		if(item==null) {
			return 15;
		}
		else {
			return 15+item.cost();
		}
	}
}
class Nuts extends Ingredients{
	Item item;
	public Nuts() {
		System.out.println("Nuts cons.......");
	}
	public Nuts(Item item) {
		this.item=item;
		System.out.println(item+"........3");

	}
	@Override
	public int cost() {
		if(item==null) {
			return 5;
		}else {
			return 5 +item.cost();
		}
	}
}
class DryFruit extends Ingredients{
	Item item;
	public DryFruit() {
		System.out.println("DryItem cons........");
	}
	public DryFruit(Item item) {
		// TODO Auto-generated constructor stub
		this.item=item;
		System.out.println(item+"........4");

	}
	
	@Override
	public int cost() {
		if(item==null) {
			return 10;
		}
		else {
			return 10+item.cost();
		}
	}
}
