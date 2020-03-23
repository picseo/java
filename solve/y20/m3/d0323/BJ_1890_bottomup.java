package d0323;

import java.util.Scanner;

public class BJ_1890_bottomup {
	static int N;
	static int[][] map;
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		dp = new long[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dp[1][1] = 1;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				int len = map[i][j];
				if(dp[i][j] == 0 || map[i][j] == 0) {
					continue;
				}
				int nx = i + len;
				if(isIn(nx, j)) {
					dp[nx][j] += dp[i][j];
				}
				int ny = j + len;
				if(isIn(i, ny)) {
					dp[i][ny] += dp[i][j];
				}
			}
		}
		
		System.out.println(dp[N][N]);
	}

	private static boolean isIn(int x, int y) {
		if(x > 0 && x <=N && y>0 && y <= N) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
