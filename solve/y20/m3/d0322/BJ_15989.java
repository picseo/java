package d0322;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15989 {
	static int[] dp = new int[10001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		dp[0] = 1;
		for(int j = 3; j >= 1; j--) {
			for(int i = j; i < 10001; i++) {
				dp[i] += dp[i-j];
			}
		}

		//System.out.println(Arrays.toString(dp));
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int n = sc.nextInt();
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}

}
