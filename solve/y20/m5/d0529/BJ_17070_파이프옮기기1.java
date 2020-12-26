package d0529;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_17070_파이프옮기기1 {
	static boolean[][] visited;
	static int[][] map;
	static int N, result;
	static int[][] dirs = {{0, 1}, {1, 0}, {1, 1}};
	static class Pipe{
		int x, y;
		//0: 가로, 1:세로, 2: 대각선
		public Pipe(int edx, int edy) {
			this.x = edx;
			this.y = edy;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = 0;
		N = sc.nextInt();
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		for(int i = 1; i < N+1 ; i++) {
			for(int j = 1; j < N+1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		Pipe start = new Pipe(1, 2);
		dfs(start, 0);		
		
		System.out.println(result);
	}

	private static void dfs(Pipe start, int type) {
		if(start.x == N && start.y == N) {
			result++;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(type == 0 && i == 1) {
				continue;
			}
			if(type == 1 && i == 0) {
				continue;
			}
			
			int nx = start.x + dirs[i][0];
			int ny = start.y + dirs[i][1];
			
			if(isIn(nx, ny) && check(nx, ny, i) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(new Pipe(nx, ny), i);
				visited[nx][ny] = false;
			}			
		}
		
		
	}

	private static boolean check(int x, int y, int type) {
		if(type == 0 || type == 1) {
			if(map[x][y] == 1) {
				return false;
			}
		}else {
			if(map[x][y] == 1 || map[x-1][y] == 1 || map[x][y-1] == 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean isIn(int x, int y) {
		boolean result = (x >0 && x <= N && y >0 && y <= N);
		return result;
	}
	
	
}
