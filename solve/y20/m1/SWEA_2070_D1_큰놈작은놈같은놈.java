package algo_basic.day1;
import java.util.*;

public class SWEA_2070_D1_큰놈작은놈같은놈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		int t=sc.nextInt();
		int num1,num2;
				
		for(int i=1;i<=t;i++) {
			num1=sc.nextInt();
			num2=sc.nextInt();
			
			if(num1>num2)
				System.out.printf("#%d >\n",i);
			else if(num1==num2)
				System.out.printf("#%d =\n",i);
			if(num1<num2)
				System.out.printf("#%d <\n",i);
			
			
			
		}

	}

}
