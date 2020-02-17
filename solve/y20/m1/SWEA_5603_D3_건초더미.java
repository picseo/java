package algo_basic.SWEA.mon1;

import java.util.Scanner;

public class SWEA_5603_D3_건초더미 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int result = 0;
			int n = sc.nextInt();
			
			int[] input = new int[n];
			int total = 0;
			for(int i = 0; i < n; i ++) {
				input[i] = sc.nextInt();
				total += input[i];
			}
			
			total /= n;
			
			for(int i =0; i < n ; i++) {
				if(input[i] > total) {
					result += (input[i]-total);
				}
			}
			
			System.out.println("#"+t+" "+result);
		}

	}

	private static String src = "\r\n" + 
			"1\r\n" + 
			"4\r\n" + 
			"2\r\n" + 
			"10\r\n" + 
			"7\r\n" + 
			"1";
}
