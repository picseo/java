package d0903;

import java.util.*;

public class BJ_1767_NRook2 {
	static int N, M, K;
	static long[][][] memo = new long[101][101][101];
	static long mod = 1000001;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		
		System.out.println(find(N, M, K));
	}

	private static long find(int n, int m, int k) {
		if(k == 0) {
			return 1;
		}
		
		if(n <= 0 || m <= 0 || k < 0) {
			return 0;
		}
		
		if(memo[n][m][k] != -1) {
			return memo[n][m][k];
		}
		
		memo[n][m][k] = 0;
		
		memo[n][m][k] = find(n-1, m, k) + find(n-1, m-1, k-1)*(m) +
				find(n-1, m-2, k-2)*(m*(m-1)/2) + find(n-2, m-1, k-2)*(m)*(n-1);
		
		memo[n][m][k] %= mod;
		return memo[n][m][k];
	}

}
