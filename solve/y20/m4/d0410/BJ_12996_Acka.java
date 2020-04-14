package d0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//완탐을 돌리기엔 경우의 수가 많은 경우
//재귀를 통해서 필요한 모든 경우를 확인하되
//memoization을 통해서 가지치기를 하면 풀수있는것 같다.
public class BJ_12996_Acka {
	static int S, D, K, H;
	static int mod = 1000000007;
	static int result = 0;
	static int[][][][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		memo = new int[S+1][D+1][K+1][H+1];
		
		for(int[][][] three : memo) {
			for(int [][] two : three) {
				for(int [] one : two) {
					Arrays.fill(one, -1);
				}
			}
		}
		
		memo[1][1][0][0] = 1;
		memo[1][1][1][0] = 1;
		memo[1][1][0][1] = 1;
		memo[1][0][1][0] = 1;
		memo[1][0][1][1] = 1;
		memo[1][0][0][1] = 1;
		memo[1][1][1][1] = 1;
		
		result = recur(S, D, K, H);
		System.out.println(result);
	}

	private static int recur(int s, int d, int k, int h) {
		//불가능한 경우
		if(s < 0 || d <0 || k < 0 || h <0) {
			return 0;
		}
		
		//값을 알 수 있는 경우
		if(memo[s][d][k][h] != -1) {
			return memo[s][d][k][h];
		}		
		
		if(s < d || s < k || s <h) {
			memo[s][d][k][h] = 0;
			return 0;
		}
		
		if(s > (d+k+h)) {
			memo[s][d][k][h] = 0;
			return 0;
		}
		
		//값을 구해야 하는 경우
		int tmp = 0;
		tmp = (tmp + recur(s-1, d-1, k, h)) % mod;
		
		tmp = (tmp + recur(s-1, d, k-1, h)) % mod;
		
		tmp = (tmp + recur(s-1, d, k, h-1)) % mod;
		
		tmp = (tmp + recur(s-1, d-1, k-1, h)) % mod;
		
		tmp = (tmp + recur(s-1, d, k-1, h-1)) % mod;
		
		tmp = (tmp + recur(s-1, d-1, k, h-1)) % mod;
		
		tmp = (tmp + recur(s-1, d-1, k-1, h-1)) % mod;
		
		
		memo[s][d][k][h] = tmp;
		return tmp;
	}

}
