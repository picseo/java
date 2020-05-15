package d0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2468_안전영역 {
	static int N;
	static int[][] map;
	static StringTokenizer st;
	static boolean[][] visited;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				max = Math.max(max, tmp);
			}
		}
		
		int result = 0;
		for(int depth = 0; depth <= max; depth++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j =0; j < N; j++) {
					if(depth >= map[i][j]) {
						visited[i][j] = true;//잠겨버림
					}else {
						if(!visited[i][j]) {
							cnt++;
							bfs(i, j, depth);
						}
					}
				}
			}
			
			//System.out.println("depth : " + depth +" , cnt : " + cnt);
			if(result < cnt) {
				result = cnt;
			}
		}
		
		System.out.println(result);
	}

	private static void bfs(int x, int y, int depth) {
		Queue<Integer> q = new LinkedList();
		visited[x][y] = true;
		q.add(x); q.add(y);
		
		while(!q.isEmpty()) {
			int px = q.poll();
			int py = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = px + dirs[d][0];
				int ny = py + dirs[d][1];
				
				if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] > depth) {
					visited[nx][ny] = true;
					q.add(nx); q.add(ny);
				}
			}
		}
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >=0 && y < N;
	}
	
}
