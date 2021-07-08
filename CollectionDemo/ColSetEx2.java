package CollectionDemo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


public class ColSetEx2 {

	public static void main(String[] args) {
		ColSetEx2 cse2 = new ColSetEx2();
		Set<Interview> pass =cse2.preparetion();
		System.out.println(pass);
	}
	public Set<Interview> preparetion(){
		Set<Interview> inp = new TreeSet<>((Tcs,Apple)->{return Tcs.fr.compareTo(Apple.fr);});
		Interview Tcs = new Interview("Online Test","Technical Round","HR Round","Tcs in Final Round ");
		Interview IBM = new Interview("Online Test","Technical Round","HR Round","IBM in Final Round  ");
		Interview Apple = new Interview("Online Test","Technical Round","HR Round","Apple in Final Round ");
		inp.add(Tcs);
		inp.add(Apple);
		inp.add(IBM);
		return inp;
		
	}

}
class Interview implements Comparable<Interview>{
	String ot ,tr,hr,fr;
	public Interview(String ot, String tr, String hr, String fr) {
		this.ot=ot;
		this.tr=tr;
		this.hr=hr;
		this.fr=fr;
	}
	public String toString() {
		return  fr+"28/08/21 Completed "+" Completed "+ot+" in 21/08/21 next "+tr+" completed in 24/08/21 "+hr+" completed in 25/08/21\n";
		
	}

	@Override
	public int compareTo(Interview o) {
		// TODO Auto-generated method stub
		return o.fr.compareTo(this.fr);
	}
	
}