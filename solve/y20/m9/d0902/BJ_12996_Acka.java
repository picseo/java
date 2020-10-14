package d0902;

import java.util.*;

public class BJ_12996_Acka {
	static int S, d, k, h;
	static long memo[][][][] = new long[51][51][51][51];
	static int mod = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		S = sc.nextInt();
		d = sc.nextInt();
		k = sc.nextInt();
		h = sc.nextInt();
		
		for(long[][][] a : memo) {
			for(long[][] b : a) {
				for(long[] c : b) {
					Arrays.fill(c, -1);
				}
			}
		}
		
		/*memo[1][0][0][1] = 1;
		memo[1][0][1][0] = 1;
		memo[1][1][0][0] = 1;
		memo[1][1][1][0] = 1;
		memo[1][1][0][1] = 1;
		memo[1][0][1][1] = 1;
		memo[1][1][1][1] = 1;
		*/
		
		find(S, d, k, h);
		
		System.out.println(memo[S][d][k][h]);
	}

	private static long find(int s, int a, int b, int c) {
		if(s < 0 || a <0 || b <0 || c < 0) {
			return 0;
		}
		
		if(memo[s][a][b][c] != -1) {
			return memo[s][a][b][c];
		}		
				
		
		if((s+a+b+c) == 0) {
			return 1;
		}
		//*******이부분이 시간을 많이 줄여주는 부분이다
		if(s < a || s < b || s <c) {
			memo[s][a][b][c] = 0;
			return 0;
		}
		
		if(s > (a+c+b)) {
			memo[s][a][b][c] = 0;
			return 0;
		}
		
		long now = 0;
		//혼자서 진행하는 경우
		now = (now + find(s-1, a-1, b, c))%mod;
		
		now = (now + find(s-1, a, b-1, c))%mod;
		
		now = (now + find(s-1, a, b, c-1))%mod;
		
		now = (now + find(s-1, a-1, b-1, c))%mod;
		
		now = (now + find(s-1, a, b-1, c-1))%mod;
		
		now = (now + find(s-1, a-1, b, c-1))%mod;
		
		now = (now + find(s-1, a-1, b-1, c-1))%mod;
		
		
		memo[s][a][b][c] = now;
		return now;
	}

	
}
