package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2071_D1_평균값구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		int t=sc.nextInt();
		int array[]=new int[10];
				
		for(int i=1;i<=t;i++) {
			double sum=0;
			for(int j=0; j<array.length;j++) {
				array[j]=sc.nextInt();
					sum+=array[j];
			}
			double avg=Math.round((sum/10));
			
			
			System.out.printf("#%d %d\n",i,(int)(avg));
			
			
			
		}

	}

}
