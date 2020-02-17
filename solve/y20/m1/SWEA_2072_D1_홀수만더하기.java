package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2072_D1_홀수만더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		int t=sc.nextInt();
		int array[]=new int[10];
				
		for(int i=1;i<=t;i++) {
			int sum=0;
			for(int j=0; j<array.length;j++) {
				array[j]=sc.nextInt();
				if(array[j]%2==1) {
					sum+=array[j];
				}
			}
			System.out.printf("#%d %d\n",i,sum);
			
			
			
		}

	}

}
