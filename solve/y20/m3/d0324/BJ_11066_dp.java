package d0324;

import java.util.Scanner;

public class BJ_11066_dp {
	static int K, N;
	static int[][] dp = new int[502][502];//dp[i][j] : i~j까지 합친 값
	static int[] sum = new int[502];//sum[i] : i번째 까지를 모두 더한 값
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			K = sc.nextInt();
			for(int i = 1; i <= K; i++) {
				int tmp = sc.nextInt();
				sum[i] = sum[i-1] + tmp; 				
			}
			
			for(int i = 1; i < K; i++) {
				for(int s = 1; s <= K-i; s++) {
					int end = s+i;
					dp[s][end] = Integer.MAX_VALUE;
					for(int e = s; e < end; e++) {
						int tmp = dp[s][e] + dp[e+1][end] + sum[end] - sum[s-1];
						dp[s][end] = Math.min(dp[s][end], tmp);
					}
				}
			}
//			
//			for(int i = 0; i <=K; i++) 
//				System.out.println(Arrays.toString(dp[i]));
			System.out.println(dp[1][K]);
		}
	}

}
