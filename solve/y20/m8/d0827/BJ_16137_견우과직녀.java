package d0827;

import java.util.*;

public class BJ_16137_견우과직녀 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;

	static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static class Point{
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}

	static Queue<Point>[] wait = new LinkedList[21];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][N];
		for(int k = 0; k < 21; k++) {
			wait[k] = new LinkedList<Point>();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for(int i =0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 && check(i, j)) {
					map[i][j] = M;
					
					visit = new boolean[N][N];
					for(int k = 0; k < 21; k++) {
						wait[k] = new LinkedList<Point>();
					}
					bfs(0, 0);
					
					map[i][j] = 0;
				}
			}
		}
		
		System.out.println(result);
	}

	private static void bfs(int sx, int sy) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(sx, sy));
		visit[sx][sy] = true;
		
		int time = 0;
		while(!q.isEmpty() ||notempty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Point now = q.poll();
				
				if(now.x == N-1 && now.y == N-1) {
					if(result > time) {
						result = time;
					}
					return;
				}
				
				for(int d = 0; d < 4; d++) {
					int nx = now.x + dirs[d][0];
					int ny = now.y + dirs[d][1];
					
					if(isIn(nx, ny) && !visit[nx][ny]) {
						if(map[nx][ny] >= 2 && map[now.x][now.y] >=2 ) {
							continue;
						}
						
						if(map[nx][ny] == 1) {
							q.add(new Point(nx, ny));
							visit[nx][ny] = true;
						}else if(map[nx][ny] >= 2) {
							visit[nx][ny] = true;
							wait[map[nx][ny]].add(new Point(nx, ny));
						}
					}
				}
				
			}
			
			time++;
			for(int i = 2; i < 21; i++) {
				if(time%i == 0) {
					while(!wait[i].isEmpty()) {
						q.add(wait[i].poll());
					}
				}
			}
		}
		
	}

	private static boolean notempty() {
		for(int i = 2; i < 21; i++) {
			if(!wait[i].isEmpty()) {
				return true;
			}
		}
		return false;
	}

	private static boolean check(int x, int y) {
		boolean up = true, right = true;

		for(int d = 0; d < 4; d++) {
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];

			if(isIn(nx, ny)) {
				if(map[nx][ny] == 0) {
					if(d%2 == 0) {
						up = false;
					}else {
						right = false;
					}
				}
			}
		}

		return up|right;
	}

	private static boolean isIn(int nx, int ny) {
		if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}

}
