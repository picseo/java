package d0528;

import java.util.Scanner;

public class SWEA_1953_탈주범검거 {
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int[][] holes = {{0, 1, 2, 3}, {2, 3}, {0, 1}, {0, 3}, {0, 2}, {1, 2}, {1, 3}};
	static boolean[][] visited;
	static int[][] time;
	static int[][] map;
	static int N, M, L, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			result = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			L = sc.nextInt();
			
			map = new int[N][M];
			time = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < N ; i++) {
				for(int j =0; j < M; j++) {
					map[i][j] = sc.nextInt();
					time[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dfs(r, c, 0);
			
			sb.append(result).append("\n");			
		}		
		System.out.println(sb);
	}
	
	private static void dfs(int x, int y, int count) {
		if(count == L) {
			return;
		}
		
		if(time[x][y] == Integer.MAX_VALUE) {
			result++;
		}
		
		if(count >= time[x][y]) {
			return;
		}else {
			time[x][y] = count;
		}
				
		int now = map[x][y]-1;
		int size = holes[now].length;
		for(int i = 0; i < size; i++) {
			int d = holes[now][i];
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];
			
			if(Isin(nx, ny) && map[nx][ny] != 0 && check(d, map[nx][ny]) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, count+1);
				visited[nx][ny] = false;
			}
		}
	}

	private static boolean check(int d, int next) {
		boolean result = false;
		next -= 1;
		if(d == 0) {//1
			if(next == 0 || next == 2 || next == 5 || next ==6) {
				result = true;
			}
		}else if(d == 1) {//0
			if(next == 0 || next == 2 || next == 3 || next ==4) {
				result = true;
			}
		}else if(d == 2) {//3
			if(next == 0 || next == 1 || next == 3 || next ==6) {
				result = true;
			}
		}else if(d == 3) {//2
			if(next == 0 || next == 1 || next == 4 || next ==5) {
				result = true;
			}
		}
		
		return result;
	}

	static boolean Isin(int x, int y) {
		return x>=0 && x < N && y >=0 && y < M;
	}	
	
	public static String src = "5\r\n" + 
			"5 6 2 1 3\r\n" + 
			"0 0 5 3 6 0\r\n" + 
			"0 0 2 0 2 0\r\n" + 
			"3 3 1 3 7 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"5 6 2 2 6\r\n" + 
			"3 0 0 0 0 3\r\n" + 
			"2 0 0 0 0 6\r\n" + 
			"1 3 1 1 3 1\r\n" + 
			"2 0 2 0 0 2\r\n" + 
			"0 0 4 3 1 1\r\n" + 
			"10 10 4 3 9\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 7 5 0 5 0 0 0\r\n" + 
			"0 0 3 2 2 6 0 0 0 0\r\n" + 
			"0 4 7 2 2 2 7 0 0 4\r\n" + 
			"0 3 0 1 1 2 2 0 0 5\r\n" + 
			"0 5 6 1 1 1 1 6 2 5\r\n" + 
			"7 4 1 2 0 0 4 6 0 0\r\n" + 
			"5 3 1 7 0 2 2 6 5 7\r\n" + 
			"7 3 2 1 1 7 1 0 2 7\r\n" + 
			"3 4 0 0 4 0 5 1 0 1\r\n" + 
			"20 20 13 11 13\r\n" + 
			"0 0 0 1 4 4 4 0 0 0 0 0 0 0 0 1 2 3 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 4 2 7 7 2 0 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 6 2 4 4 2 0 4 7 0 6 0\r\n" + 
			"0 0 0 7 5 5 3 0 0 7 5 0 5 6 4 2 6 3 1 5\r\n" + 
			"0 0 0 1 2 6 3 3 7 0 3 6 2 4 5 6 7 7 5 7\r\n" + 
			"0 0 0 3 7 6 1 5 3 3 4 5 7 6 0 4 3 3 1 1\r\n" + 
			"0 1 2 1 5 6 1 6 1 6 5 1 6 0 0 3 4 1 7 6\r\n" + 
			"0 2 3 2 2 7 3 0 0 3 2 5 2 1 0 6 5 1 6 5\r\n" + 
			"0 2 5 7 0 7 1 3 3 4 1 3 3 0 2 3 3 2 4 1\r\n" + 
			"4 0 0 7 2 4 2 2 1 3 1 6 5 5 6 2 5 1 1 6\r\n" + 
			"5 6 4 0 3 6 5 2 2 6 1 2 0 1 7 5 7 2 2 2\r\n" + 
			"1 6 3 1 4 4 1 0 3 0 4 2 7 2 0 2 3 6 2 5\r\n" + 
			"1 5 7 2 1 1 4 4 2 1 0 2 7 1 6 2 6 6 2 2\r\n" + 
			"3 7 0 6 5 0 4 0 6 6 7 1 3 1 1 1 5 1 6 6\r\n" + 
			"0 4 0 1 6 2 1 0 7 0 4 2 5 2 7 0 2 7 1 6\r\n" + 
			"0 7 3 0 1 7 6 2 0 0 4 2 4 1 3 3 7 0 1 3\r\n" + 
			"0 1 1 4 3 7 4 5 2 2 4 7 4 7 7 4 6 0 1 6\r\n" + 
			"0 5 2 2 1 4 6 3 7 0 6 3 5 0 0 6 4 4 2 1\r\n" + 
			"0 1 2 4 5 6 0 2 0 0 5 6 2 4 6 4 7 6 3 7\r\n" + 
			"7 7 4 2 3 0 0 4 0 0 7 2 7 5 6 1 4 5 5 4\r\n" + 
			"50 50 20 12 18\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 4 5 0 0 0 0 0 4 2 0 5 2 1 5 3 3 0 0 4 0 5 1 7 2 6 0 7 0 0 0 2 0 0 0 0 0 0 0\r\n" + 
			"6 7 0 0 0 0 0 0 0 0 0 0 4 5 5 3 6 3 0 2 3 3 0 0 5 6 1 5 3 4 7 6 2 2 1 1 6 5 6 4 6 2 0 0 0 0 2 3 1 0\r\n" + 
			"0 2 6 5 7 6 0 0 0 0 0 0 6 2 0 5 6 2 0 4 1 5 0 0 2 0 7 7 0 6 0 6 2 2 4 1 2 2 1 6 6 6 0 2 2 5 0 6 5 0\r\n" + 
			"0 0 0 4 7 2 7 3 7 0 0 0 0 6 7 6 5 1 1 1 2 2 1 3 1 2 7 6 1 2 1 2 4 1 6 1 1 7 3 1 6 6 6 1 1 1 7 0 0 0\r\n" + 
			"0 0 0 5 4 0 6 3 3 7 0 0 0 6 4 3 2 5 3 1 6 1 0 4 1 0 5 7 6 3 1 1 3 6 1 1 6 3 6 7 3 3 6 5 0 7 2 2 4 6\r\n" + 
			"0 6 0 7 6 0 7 4 0 5 3 0 4 3 2 0 5 7 3 0 1 3 6 7 7 5 1 7 5 2 0 5 3 1 3 7 1 1 1 5 2 5 1 3 6 7 7 6 4 3\r\n" + 
			"5 2 0 2 6 5 0 5 6 1 6 5 5 1 7 1 2 3 6 5 1 6 7 7 6 4 1 7 5 2 0 1 3 4 6 4 5 7 2 6 5 6 2 5 6 5 6 5 1 6\r\n" + 
			"1 2 0 7 0 5 5 0 7 6 2 2 1 3 5 5 3 6 3 7 6 4 1 3 1 3 7 0 3 7 0 2 5 6 1 3 4 1 5 1 7 4 1 7 7 0 4 7 5 5\r\n" + 
			"7 6 0 3 5 1 4 0 5 2 5 0 1 3 5 5 4 4 6 1 6 5 7 6 2 1 6 5 5 3 0 5 7 1 1 3 6 2 2 2 4 5 7 4 5 1 1 0 7 3\r\n" + 
			"2 5 4 0 3 1 4 5 6 3 7 0 4 5 3 6 4 5 1 7 4 7 3 1 1 7 7 1 1 5 6 4 7 1 2 6 4 1 7 2 7 1 6 0 5 0 0 0 1 0\r\n" + 
			"3 0 2 5 1 7 1 1 1 6 5 1 3 1 3 1 1 7 1 3 6 5 5 3 1 3 1 6 2 3 2 6 6 1 1 7 5 7 5 7 1 6 0 3 5 1 5 3 0 0\r\n" + 
			"0 0 3 2 0 1 4 1 4 1 0 7 3 2 2 4 2 4 4 6 1 1 1 7 2 4 7 4 3 6 3 5 1 6 1 3 7 7 2 6 3 2 1 0 4 6 2 6 3 0\r\n" + 
			"0 0 5 4 7 2 4 6 4 1 6 7 2 2 1 6 2 1 5 4 7 2 2 1 0 7 6 1 7 2 5 7 0 4 1 6 4 0 3 0 0 5 5 0 7 7 0 3 0 0\r\n" + 
			"0 0 6 4 3 1 3 1 4 7 2 1 2 4 3 4 1 6 2 1 5 1 1 6 0 7 2 7 2 4 7 4 0 3 7 7 3 3 5 2 0 4 3 0 4 2 0 1 3 5\r\n" + 
			"0 1 0 5 6 4 4 6 5 7 0 6 1 4 5 6 2 1 2 4 4 1 1 2 6 1 6 2 0 3 7 3 0 0 5 1 7 6 6 6 1 3 4 2 1 0 7 0 5 5\r\n" + 
			"0 7 2 1 4 2 7 3 0 2 1 4 3 5 1 1 1 1 7 1 4 4 1 7 6 0 1 2 0 5 2 0 0 0 5 4 0 3 7 5 3 1 4 1 2 7 2 6 6 4\r\n" + 
			"0 1 3 0 3 4 6 3 4 2 4 0 7 5 1 1 2 7 1 6 4 2 2 0 5 6 3 3 1 1 0 0 0 3 0 4 5 4 3 1 1 6 1 6 2 0 1 4 7 7\r\n" + 
			"0 3 0 0 2 6 1 4 7 5 1 4 3 2 5 1 4 3 6 3 0 2 4 5 7 5 6 2 0 5 6 3 6 4 6 2 0 0 6 0 7 2 2 6 0 0 0 0 0 0\r\n" + 
			"0 6 7 1 6 4 3 6 0 2 6 7 6 2 1 6 6 6 2 0 0 7 3 0 1 1 2 0 0 0 3 1 6 7 5 6 4 1 7 5 2 0 2 6 0 0 0 0 4 0\r\n" + 
			"0 6 7 7 3 3 0 2 0 1 6 4 1 1 1 6 2 3 3 4 2 3 5 0 5 7 7 6 2 7 2 7 3 1 0 5 6 7 1 6 4 1 5 0 0 0 0 0 0 0\r\n" + 
			"0 7 3 0 4 3 0 0 6 6 0 5 1 1 1 1 1 6 0 0 7 0 0 0 2 4 3 2 3 3 6 0 0 1 0 2 6 7 3 4 0 3 2 4 0 0 0 0 0 7\r\n" + 
			"0 0 4 7 2 0 0 0 1 4 2 4 7 7 2 4 2 4 0 5 6 0 0 0 7 0 2 7 4 4 1 6 1 4 2 3 6 2 0 6 5 3 5 0 3 5 6 0 0 1\r\n" + 
			"0 0 7 4 7 0 3 0 4 4 6 2 4 7 0 5 7 1 3 6 5 6 6 7 3 3 6 6 4 2 0 0 3 0 4 7 2 6 4 0 6 2 4 6 7 1 7 2 7 1\r\n" + 
			"0 0 2 6 0 0 6 5 0 4 1 2 2 2 2 7 2 1 0 4 6 4 1 0 1 1 2 2 0 4 4 2 0 0 3 0 3 6 2 2 7 6 6 0 4 6 0 2 2 2\r\n" + 
			"0 0 4 4 7 1 1 1 7 3 7 6 2 3 3 0 5 0 0 6 1 2 6 3 1 7 0 4 7 4 3 6 1 5 1 0 3 7 4 0 3 0 5 6 2 0 0 3 0 5\r\n" + 
			"0 0 7 3 0 5 4 0 7 4 0 0 4 5 7 1 3 2 3 3 5 3 5 3 5 5 5 5 4 2 3 6 0 3 1 7 2 4 5 3 0 0 5 3 6 0 0 7 3 6\r\n" + 
			"0 0 3 5 0 0 1 1 1 0 0 0 5 3 5 5 1 2 7 0 4 3 1 6 7 1 5 7 4 4 5 7 0 3 6 3 3 7 7 4 1 3 5 2 0 0 0 7 7 4\r\n" + 
			"0 0 7 6 3 5 0 7 2 7 7 5 4 0 0 7 0 4 0 0 3 2 3 1 5 7 4 6 0 3 5 5 2 0 6 0 0 0 2 1 1 4 3 6 2 0 5 1 1 6\r\n" + 
			"0 0 1 0 4 1 0 2 5 0 0 0 6 7 3 7 0 0 0 0 4 3 3 3 0 1 0 0 0 1 5 1 5 4 5 1 7 0 0 5 0 5 6 0 3 2 5 0 3 4\r\n" + 
			"0 0 0 0 0 4 0 2 3 1 6 6 6 3 5 3 6 0 0 0 4 7 0 6 1 7 1 0 0 5 5 2 5 1 0 1 1 3 3 4 1 4 2 0 6 3 0 0 6 4\r\n" + 
			"6 4 2 2 0 0 0 3 3 0 0 1 4 0 5 0 2 0 7 0 1 7 7 1 5 7 0 0 0 3 1 5 5 6 0 6 2 6 4 0 7 6 5 1 3 3 7 0 2 5\r\n" + 
			"0 0 0 7 7 0 0 4 4 3 1 6 1 0 1 3 3 1 4 5 7 3 7 0 0 4 0 0 0 7 3 7 2 2 0 1 5 0 7 5 5 2 5 1 0 2 0 0 3 2\r\n" + 
			"0 0 0 3 0 0 0 0 1 2 6 7 1 6 7 0 3 5 2 7 3 0 4 5 2 0 0 0 0 2 5 7 3 7 5 6 0 0 2 2 5 4 7 6 4 5 1 4 4 6\r\n" + 
			"0 4 3 0 0 0 0 3 5 6 3 2 0 3 6 0 6 0 0 1 4 3 6 2 4 7 4 7 1 5 0 4 0 0 2 0 0 0 3 7 6 1 2 5 3 5 2 3 3 3\r\n" + 
			"0 0 0 1 4 0 0 2 1 0 2 0 0 1 7 3 4 3 3 4 7 0 6 7 4 7 3 1 6 1 7 3 4 4 7 5 2 1 3 7 2 5 2 3 3 2 3 0 1 2\r\n" + 
			"0 0 0 0 1 1 0 0 5 7 3 6 6 0 0 6 5 4 2 7 0 0 4 5 5 0 5 7 3 3 0 3 5 5 3 6 0 0 3 5 4 0 0 7 5 1 6 0 0 7\r\n" + 
			"0 0 0 0 5 6 3 1 5 2 0 7 7 7 0 0 1 0 3 6 4 1 6 7 2 1 6 5 2 0 0 7 4 5 0 0 0 0 0 6 6 0 0 5 6 0 2 3 4 5\r\n" + 
			"0 0 7 1 0 1 6 5 6 0 0 5 4 5 7 1 1 6 5 2 2 0 3 7 4 5 2 6 4 0 0 3 4 0 0 0 0 0 0 7 7 7 7 6 4 3 4 4 0 0\r\n" + 
			"0 0 0 1 3 0 0 3 7 1 1 0 4 1 4 4 2 6 1 6 2 2 7 4 2 4 1 7 1 6 4 3 3 1 3 4 0 0 3 2 0 2 0 1 3 3 4 7 1 5\r\n" + 
			"0 0 0 3 4 0 0 2 0 5 5 0 0 1 4 4 0 4 0 1 6 6 4 2 1 0 0 3 7 0 4 3 3 2 3 5 3 5 0 4 0 5 0 3 0 7 7 3 5 6\r\n" + 
			"0 0 0 7 2 0 0 4 2 2 6 2 2 5 0 5 0 3 4 3 5 5 2 0 4 0 0 5 0 0 4 1 6 4 4 3 4 0 0 5 0 1 1 2 0 7 3 4 0 4\r\n" + 
			"0 0 1 1 4 4 1 0 0 0 3 5 4 5 4 2 7 4 6 1 6 7 0 3 0 7 1 7 6 6 3 0 5 7 6 6 4 7 3 4 5 0 0 0 0 6 1 1 5 3\r\n" + 
			"0 0 4 2 5 7 4 4 2 1 2 1 3 4 7 2 7 2 1 6 3 3 0 7 5 6 6 4 5 5 3 3 2 7 5 3 1 4 7 0 0 0 0 0 0 3 1 5 6 5\r\n" + 
			"0 0 0 4 4 1 0 0 6 0 0 7 5 7 5 1 7 3 6 0 2 4 3 4 7 7 3 0 0 0 1 5 5 0 6 7 7 7 4 4 3 6 3 7 5 0 1 1 0 2\r\n" + 
			"0 0 0 1 3 4 7 2 5 0 0 4 4 0 5 2 2 0 1 7 0 1 1 3 6 5 2 6 2 7 7 3 6 7 1 3 4 6 7 5 3 7 4 6 0 0 0 4 3 1\r\n" + 
			"0 0 0 2 1 6 3 5 4 0 0 6 0 0 6 7 0 0 5 2 0 7 7 0 7 0 0 7 7 6 0 0 1 1 0 1 0 1 3 1 0 0 4 7 7 0 0 0 2 6\r\n" + 
			"0 0 0 2 4 0 6 7 2 4 1 5 6 3 0 0 0 0 4 2 7 1 1 5 2 0 0 7 2 2 3 1 3 5 5 7 7 4 0 3 4 2 3 0 0 4 6 6 0 1\r\n" + 
			"0 0 0 4 6 1 0 3 6 4 7 3 5 0 0 0 0 0 0 7 0 0 3 6 2 1 0 2 3 4 6 7 5 0 7 0 5 4 5 1 5 0 0 0 0 4 5 3 1 0\r\n" + 
			"1 3 6 5 5 2 3 7 6 1 0 6 7 3 2 5 6 7 6 6 0 0 7 1 0 5 5 0 3 0 2 0 7 4 5 3 2 5 1 5 3 0 0 0 1 2 0 1 0 0\r\n" + 
			"1 7 3 0 2 0 7 0 4 6 1 1 5 0 7 0 5 7 7 2 6 0 0 1 0 2 3 3 4 2 7 5 3 7 0 0 4 6 6 6 3 0 0 0 7 7 7 5 7 2\r\n" + 
			"";
}
