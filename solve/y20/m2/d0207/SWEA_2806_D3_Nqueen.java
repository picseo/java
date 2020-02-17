package swea.d0207;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2806_D3_Nqueen {
	private static int[][] map;
	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t =1 ; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];

			System.out.println("#"+t+" "+dfs(N, 0));
		}		
	}
	
	public static int dfs(int n, int cur) {
		int result = 0;
		if(n == cur) {
			return 1;
		}else {
			for(int j = 0; j < n; j++) {
				if(isPromising(cur, j)) {
					map[cur][j] = 1;
					result += dfs(n, cur+1);
					map[cur][j] = 0;
				}
			}
		}
		return result;
	}
	
	public static boolean isPromising(int x, int y) {
		int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}};
		
		for(int i = 0; i < 3; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			
			while(isIn(nx, ny, N)) {
				if(map[nx][ny] == 1) {
					return false;
				}else {
					nx += dirs[i][0];
					ny += dirs[i][1];
				}
			}
		}
		
		return true;
	}
	
	public static boolean isIn(int x, int y, int len) {
		if(x >= 0 && x < len && y >=0 && y< len)
			return true;
		else 
			return false;
	}
	private static String src = "2\r\n" + 
			"1\r\n" + 
			"2";
}
