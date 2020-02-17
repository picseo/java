package algo_basic.day1;

import java.util.Scanner;

public class SWEA_1204_D2_최빈수구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int t=sc.nextInt();
		
		for(int i=0; i<t;i++) {
			int num=sc.nextInt();
			int n_array[] = new int[1000];
			int c_array[] = new int[101];
			
			for(int j=0;j<n_array.length;j++) {
				n_array[j]=sc.nextInt();
				c_array[n_array[j]]++;
			}
			
			int max_count=0;
			int max_num=0;
			for(int j=0;j<c_array.length;j++) {
				
				if(max_count<=c_array[j]) {
					max_count=c_array[j];
					max_num=Math.max(max_num,j);
				}
			}
			
			System.out.printf("#%d %d\n",num,max_num);
	
		}
	}

}
