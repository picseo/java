package d0323;

import java.util.Scanner;

public class BJ_1495 {
	static int N, S, M;
	static int[] V = new int[1001];
	static boolean[][] dp = new boolean[101][1001];
	static int result = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			V[i] = sc.nextInt();
		}

		dp[0][S] = true;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= M; j++) {
				if(dp[i-1][j]) {
					if(j-V[i] >= 0) {
						dp[i][j-V[i]] = true;
					}
					if(j+V[i] <= M) {
						dp[i][j+V[i]] = true;
					}
				}
			}
		}
		
		for(int i = 0; i <= M; i++) {
			if(dp[N][i]) {
				if(i > result) {
					result = i;
				}
			}
		}

		System.out.println(result);
	}

}
