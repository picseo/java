package algo;

import java.util.Scanner;

public class BJ_2098_외판원순회_DP_bitmasking_혼자못품 {
	static int N;
	static int[][] W;
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				W[i][j] = sc.nextInt();
			}
		}
		
		memo = new int[N][1<<N];
		System.out.println(tsp(0, 1));
		
		
	}

	private static int tsp(int idx, int visit) {
		if(visit == (1<<N)-1) {
			if(W[idx][0] != 0) {
				return W[idx][0];
			}
		}
		
		int ret = memo[idx][visit];
		if(ret != 0) return ret;
		memo[idx][visit] = 20000000;
		
		for(int i = 0;i < N; i++) {
			if(((visit&(1<<i)) ==0)&& W[idx][i] != 0) {
				memo[idx][visit] = Math.min(memo[idx][visit], W[idx][i] + tsp(i, visit|(1<<i)));
			}
		}
		
		return memo[idx][visit];
	}
}
