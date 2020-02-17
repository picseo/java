package algo_basic.day1;

import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class SWEA_2029_D1_몫과나머지출력하기 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		for(int i=1; i<=tc; i++) {
			int num1=sc.nextInt();
			int num2=sc.nextInt();
			
			System.out.printf("#%d %d %d\n",i,(num1/num2),(num1%num2));
			
		}

	}

}
