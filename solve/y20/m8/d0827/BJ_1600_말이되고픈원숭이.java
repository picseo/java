package d0827;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 최소한의 동작이므로 bfs로 구해야 되겠다.
 * 
 * k의 갯수도 고려해줘야한다!!!!!!!!!
 * 
 */

public class BJ_1600_말이되고픈원숭이 {
	static int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	static int[][] hdirs = {{2, -1}, {2, 1}, {-2, -1}, {-2, 1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};

	static int K, N, M;
	static int[][] map;

	static class Point{
		int x, y, k;

		Point(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();

		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cnt = bfs(0, 0, K);
		System.out.println(cnt);
	}

	private static boolean isIn(int x, int y) {
		if(x >=0 && x < N && y >=0 && y < M) {
			return true;
		}
		return false;
	}

	private static int bfs(int sx, int sy, int k) {
		boolean[][][] visit = new boolean[N][M][K+1];

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(sx, sy, k));
		visit[sx][sy][k] = true;

		int cnt = 0;
		while(!q.isEmpty()) {			
			int size = q.size();
			for(int s= 0; s < size; s++) {
				Point now = q.poll();

				if(now.x == N-1 && now.y == M-1) {
					return cnt;
				}
				
				if(now.k >= 1) {
					for(int d = 0; d < 8; d++) {
						int nx = now.x + hdirs[d][0];
						int ny = now.y + hdirs[d][1];

						if(isIn(nx, ny) && map[nx][ny] == 0) {
							if(!visit[nx][ny][now.k-1]) {
								visit[nx][ny][now.k-1] = true;
								q.add(new Point(nx, ny, now.k-1));
							}
						}
					}
				}

				for(int d = 0; d < 4; d++) {
					int nx = now.x + dirs[d][0];
					int ny = now.y + dirs[d][1];

					if(isIn(nx, ny) && map[nx][ny] == 0) {
						if(!visit[nx][ny][now.k]) {
							visit[nx][ny][now.k] = true;
							q.add(new Point(nx, ny, now.k));
						}
					}
				}
			}

			cnt++;
		}

		return -1;
	}


}
