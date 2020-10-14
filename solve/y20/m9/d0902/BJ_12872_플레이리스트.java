package d0902;

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
		
		//필요한 곡수, 현재 포함한 노래갯수
		System.out.println(find(0, 0));
	}

	private static long find(int p, int x) {
		
		if(p == P) {
			if(x == N) {
				return 1;
			}
			return 0;
		}
		
		if(memo[p][x] != -1) {
			return memo[p][x];
		}
		
		long tmp = 0;
		if(x > M) {
			tmp = ((tmp + find(p+1, x))*(x-M))%mod;
		}
		
			tmp = ((tmp + find(p+1, x+1)*(N-x))%mod);
		
		memo[p][x] = tmp%mod;
		
		return memo[p][x];
	
	}

}
