package d0323;

import java.util.Scanner;

public class BJ_1890_topdown {
	static int N;
	static int[][] map;
	static long[][] dp;

	private static long find(int x, int y) {
		if(dp[x][y] != -1) {
			return dp[x][y];
		}

		if(x == 1 && y == 1) {
			dp[x][y] = 1;
			return 1;
		}else {
			dp[x][y] = 0;
			for(int i = 1; i <= N; i++) {
				if(x-i >= 1 && map[x-i][y] == i)
					dp[x][y] += find(x-i, y);
			}

			for(int i = 1; i <= N; i++) {
				if(y-i >= 1 && map[x][y-i] == i)
					dp[x][y] += find(x, y-i);
			}
		}
		return dp[x][y];
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N+1][N+1];
		dp = new long[N+1][N+1];

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}

		System.out.println(find(N, N));
	}
}
