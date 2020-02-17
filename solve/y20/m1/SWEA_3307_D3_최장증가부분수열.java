package algo_basic.day1;

import java.util.Scanner;


public class SWEA_3307_D3_최장증가부분수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i=1; i<=tc; i++) {
			int n=sc.nextInt();
			
			int count=0;
				
			int[] n_array = new int[n];
			for(int j=0; j<n;j++) {
				n_array[j]=sc.nextInt();
			}
			int temp=0;
			count=getcount(n_array,0,0);
			
			System.out.printf("#%d %d\n",i,count);
			
		}
		
	}
	
	public static int getcount(int[] array, int num,int temp) {
		int count=0;
		
		for(int j=num; j<array.length;j++) {
			if(temp<=array[j]) {
//				System.out.println(array[j]+"/"+j);
				temp=array[j];
				count+=getcount(array,j,temp);
				
			}
			else {
//				System.out.println(array[j]+"/"+j);

			
				break;	
				
			}
		}
		return count;
		
	}

}
