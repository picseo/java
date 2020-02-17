package algo_basic.day1;

import java.util.Scanner;

public class SWEA_5215_D3_햄버거다이어트 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <= tc; i++) {
			int n=sc.nextInt();
			int l=sc.nextInt();
			int score[]=new int[n];
			int cal[]=new int[n];
			int max=0;
			int range=1;
			
			
			for(int j=0; j<n; j++) {
				score[j]=sc.nextInt();
				cal[j]=sc.nextInt();
				System.out.println("재료, 칼ㄹ로리"+score[j]+"//"+cal[j]);
				range*=(j+1);
			}
			
			int total[][] = new int[2][range];
			
			
			
			
			
			
			
			
			for(int j=0; j<range;j++) {
				if(total[1][j]<=1000){
					if(max<total[0][j]) {
						max=total[0][j];
					}
				}
			}
			
			System.out.printf("#%d %d\n",i,max);
			
			
		}
	}

}
