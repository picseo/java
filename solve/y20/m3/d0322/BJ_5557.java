package d0322;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_5557 {
	static int MAX = 101;
//	static long[][] dp = new long[101][21];
//	static int[] input = new int[101];
//	static long result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[][] dp = new long[101][21];
		int[] input = new int[101];
		long result = 0;
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		
		dp[0][input[0]] = 1;
		for(int i = 1; i < n-1; i++) {
			for(int j = 0; j < 21; j++) {
				if(dp[i-1][j] != 0) {
					if(0<= j-input[i]) {
						dp[i][j-input[i]] += dp[i-1][j];
					}
					if(j+input[i] <= 20) {
						dp[i][j+input[i]] += dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[n-2][input[n-1]]);
	}

}
