package d0902;

import java.util.*;

public class BJ_12969_ABC {
	static int N, K;
	static boolean[][][][] memo = new boolean[31][31][31][436];
	static char[] res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();

		res = new char[N];
		if(recur(0, 0, 0, 0)) {
			System.out.println(new String(res));
		}else {
			System.out.println(-1);
		}
	}

	private static boolean recur(int idx, int k, int a, int b) {
		if(idx == N) {
			if(k == K) {
				return true;
			}else {
				return false;
			}
		}
		
		if(memo[idx][a][b][k]) return false; //이미 확인했으니 더 할 필요없음
		memo[idx][a][b][k] = true;
	
		res[idx] = 'A';
		if(recur(idx+1, k, a+1, b)) { return true;}
	
		res[idx] = 'B';
		if(recur(idx+1, k+a, a, b+1)) { return true;}
		
		res[idx] = 'C';
		if(recur(idx+1, k+a+b, a, b)) { return true;}
		
		return false;
	}

	/*private static int recur(char[] res, int idx, int k, int a, int b, int c) {
		if(memo[a][b][c] != -1)
			return memo[a][b][c];
		
		if(k == 0 && idx == N) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < res.length; i++) {
				sb.append(res[i]);
			}
			result = sb.toString();
			memo[a][b][c] = 1;
			return memo[a][b][c];
		}
		
		if(idx >= N || k > 0 && idx == N ) {
			memo[a][b][c] = 0;
			return memo[a][b][c];
		}
		
		//현재 a를 고를때
		res[idx] = 'A';
		int nextk = 0;
		if(recur(res, idx+1, k, a+1, b, c) == 1) {
			memo[a][b][c] = 1;
			return memo[a][b][c];
		}
	
		res[idx] = 'B';
		if(k-a >= 0) {
			if(recur(res, idx+1, k-a, a, b+1, c) == 1) {
				memo[a][b][c] = 1;
				return memo[a][b][c];
			}
		}
		
		res[idx] = 'C';
		if(k - (a+b) >= 0) {
			if(recur(res, idx+1, k-(a+b), a, b, c+1) == 1) {
				memo[a][b][c] = 1;
				return memo[a][b][c];
			}
		}
		
		memo[a][b][c] = 0;
		return memo[a][b][c];
	}*/

}
