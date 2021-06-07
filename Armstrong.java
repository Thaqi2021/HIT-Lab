import java.util.*;
public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num = 371 ,  orgnum =num, rem ,result =0;
        while(orgnum!=0) {
        	rem = orgnum % 10;
        	orgnum = orgnum/10;
        	result += (rem*rem*rem);

        }
        if(num == result) {
            System.out.println("Amstrong is Proved "+result);

        }
        else {
            System.out.println(result+" Is Not a Amstrong Number ");

        }
	}

}
