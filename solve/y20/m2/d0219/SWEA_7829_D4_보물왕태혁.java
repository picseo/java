package solve.s0219;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_7829_D4_º¸¹°¿ÕÅÂÇõ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			long[] input = new long[n];
			
			for(int i = 0; i < n; i++) {
				input[i] = sc.nextInt();
			}
			
			Arrays.sort(input);
			long result = 0;
			if(n%2 ==0) {
				result = input[0] * input[n-1];
			}else {
				int mid = n/2;
				result = input[mid] * input[mid];
			}
			
			System.out.println("#"+t+" "+result);
		}
		
	}

	private static String src = "3\r\n" + 
			"4\r\n" + 
			"2 3 4 6\r\n" + 
			"3\r\n" + 
			"27 3 9\r\n" + 
			"1\r\n" + 
			"13";
}
