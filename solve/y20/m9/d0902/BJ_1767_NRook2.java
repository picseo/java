package d0902;

import java.util.*;

public class BJ_1767_NRook2 {
	static int N, M, K;
	static int mod = 1000001;
	static int[][][] memo = new int[101][101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		for(int[][] a : memo) {
			for(int [] b : a) {
				Arrays.fill(b,  -1);
			}
		}
		
		System.out.println(find(N, M, K));
	}

	private static int find(int n, int m, int k) {
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
		memo[n][m][k] = find(n-1, m, k) + find(n-1, m-1, k-1)*(m)+
				find(n-1, m-2, k-2)*(m*(m-1)/2) + find(n-2, m-1, k-2)*m*(n-1);
		memo[n][m][k] %= mod;
		return memo[n][m][k];
	}
}
