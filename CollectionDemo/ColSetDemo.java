package CollectionDemo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

 

public class ColSetDemo {
	public static void main(String[] args) {
		ColSetDemo csd = new ColSetDemo();
		Set<Question> qset=csd.myquestion();
		System.out.println(qset);

		
	}

	public Set<Question> myquestion(){
		Set<Question> questionSet=new TreeSet<>((q1,q2)->{
			return q2.qsn.compareTo(q1.qsn);
			});//Comparable
//		Set<Question> questionSet=new TreeSet<>(new MyQuestionComparator());                 //Comparator
//		Set<Question> questionSet=new TreeSet<>(new Comparator<Question>() {				 //Second way of calling comparator
//			@Override
//			public int compare(Question o1, Question o2) {
//				return o1.compareTo(o2);
//			}
//		});

		Question q1= new Question("1", "who is cm", "chiefmember", "chiefminister", "chiefmajor", "2");
		Question q2= new Question("2", "who is pm", "primemember", "primeminister", "primemajor", "2");
		Question q3= new Question("3", "who is dm", "districtmember", "districtmajistrate", "districtmajor", "2");
		Question q4= new Question("4", "who is hm", "headmember", "headmaster", "headmajor", "2");
		Question q5= new Question("5", "who is cm", "chiefmember", "chiefminister", "chiefmajor", "2");
		questionSet.add(q1);
		questionSet.add(q2);
		questionSet.add(q3);
		questionSet.add(q4);
		questionSet.add(q5);
		return questionSet;
		
	}
}
class Question implements Comparable<Question>{
	String qsn,ques,op1,op2,op3,ans;
	public Question(String qsn, String ques, String op1, String op2, String op3, String ans) {
		super();
		this.qsn = qsn;
		this.ques = ques;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.ans = ans;
	}
	@Override
	public String toString() {
		return " Question [qid=" + qsn + ", question=" + ques + ", option1=" + op1 + ", option2=" + op2
				+ ", option3=" + op3 + ", answer=" + ans + "]\n";
	}
	@Override
	public int compareTo(Question o) {
		// TODO Auto-generated method stub
		return o.qsn.compareTo(this.qsn);
	}
	
}
class MyQuestionComparator implements Comparator<Question>{
	@Override
	public int compare(Question o1, Question o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);
	}
}
