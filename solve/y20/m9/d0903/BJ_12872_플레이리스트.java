package d0903;

import java.util.*;

public class BJ_12872_플레이리스트 {
	static int N, M, P;
	static long mod = 1000000007;
	static long[][] memo = new long[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		P = sc.nextInt();
		
		for(int i = 0; i < 101; i++) {
			Arrays.fill(memo[i], -1);
		}
		
		System.out.println(find(0, 0));
	}

	private static long find(int p, int n) {
		if(p == P) {
			if(n == N) {
				return 1;
			}
			return 0;
		}
		
		if(memo[p][n] != -1) {
			return memo[p][n];
		}
		
		memo[p][n] = 0;
		//한개 새로운 곡 추가
		memo[p][n] += find(p+1, n+1)*(N-n);
		
		//이미 사용한 곡 추가
		if(n > M) {
			memo[p][n] += find(p+1, n)*(n-M);
		}
		
		memo[p][n] %= mod;
		
		return memo[p][n];
	}

}
