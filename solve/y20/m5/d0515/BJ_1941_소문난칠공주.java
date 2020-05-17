package d0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BJ_1941_소문난칠공주 {
	static char[][] map = new char[5][5];
	static boolean[] visited = new boolean[25];
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int result = 0;
	static Stack<Character> stack = new Stack<Character>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		result = 0;
		for(int i = 0; i < 25; i++) {
			visited[i] = true;
			if(map[i/5][i%5] == 'Y') {
				dfs(i, 1, 0);
			}else if(map[i/5][i%5] == 'S') {
				dfs(i, 0, 1);
			}
			visited[i] = false;
		}
		
		System.out.println(result);
	}

	private static void dfs(int idx, int ycnt, int scnt) {
		if(ycnt >= 4) {
			return;
		}
		
		if(ycnt + scnt == 7) {
			if(scnt > ycnt) {
				if(check_bfs(idx)) {
					result++;
				}
			}
			return;
		}
		
		for(int i = idx+1; i <25; i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			if(map[i/5][i%5] == 'Y') {
				dfs(i, ycnt+1, scnt);
			}else if(map[i/5][i%5] == 'S') {
				dfs(i, ycnt, scnt+1);
			}
			visited[i] = false;
		}
	}
	
	private static boolean check_bfs(int idx) {
		Queue<Integer> q = new LinkedList();
		int x = idx/5;
		int y = idx%5;
		q.add(x); q.add(y);
		boolean[][] inner_visit = new boolean[5][5];
		inner_visit[x][y] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int qx = q.poll();
			int qy = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = qx + dirs[d][0];
				int ny = qy + dirs[d][1];
				
				if(isIn(nx, ny) && visited[nx*5+ny] && !inner_visit[nx][ny]) {
					q.add(nx); q.add(ny);
					inner_visit[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		if(cnt == 7) {
			return true;
		}else {
			return false;
		}
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x <5 && y >=0 && y <5;
	}
}
