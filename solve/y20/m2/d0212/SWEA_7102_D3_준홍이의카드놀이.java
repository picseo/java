package algo_basic.SWEA.d0212;

import java.util.Scanner;

public class SWEA_7102_D3_준홍이의카드놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T= sc.nextInt();
		for(int t= 1; t<= T; t++) {
			int result = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] sums = new int[n+m+1];
			
			for(int i = 1; i < n+1; i++) {
				for(int j = 1; j < m+1; j++) {
					int sum = i+j;
					sums[sum]++;
				}
			}
			
			int max = -1;
			for(int i = 1; i < n+m+1; i++) {
				if(max < sums[i]) {
					max = sums[i];
				}
			}		
			
			System.out.print("#"+t);
			for(int i = 1; i < n + m + 1; i++) {
				if(sums[i] == max)
					System.out.print(" "+i);
			}
			System.out.println();
		}

	}
	
	private static String src = "2\r\n" + 
			"6 6\r\n" + 
			"6 4";
}
