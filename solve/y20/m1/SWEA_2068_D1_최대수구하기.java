package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2068_D1_최대수구하기 {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		int t=sc.nextInt();
		int[] max = new int[t];
		
		for (int i = 1; i <= t; i++) {
			max[i-1]=0;
			for(int j=0;j<10; j++) {
				int num=sc.nextInt();
				if(max[i-1]<num) {
					max[i-1]=num;
				}
			}
			
			System.out.printf("#%d %d\n",i,max[i-1]);
		}
		

	}

}
