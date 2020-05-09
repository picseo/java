package d0417;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 3차원 배열을 사용하는 bfs문제 였다.
 * 
 * */
public class BJ_6593_상범빌딩 {
	static int L, R, C;
	static char[][][] map;
	static boolean [][][] visited;
	static Point sp, ep;
	static int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 1, 0}, 
			{0, 0, -1}, {0, 0, 1}};
	static class Point{
		int z, x, y;

		Point(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		while(true) {
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();

			if(L == 0 && R == 0 && C == 0) {
				break;
			}

			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R ; j++) {
					map[i][j] = sc.next().toCharArray();
					for(int k = 0; k < C; k++) {
						if(map[i][j][k] == 'S') {
							sp = new Point(i, j, k);
						}else if(map[i][j][k] == 'E') {
							ep = new Point(i, j, k);
						}
					}
				}
			}

			int result = bfs();
			if(result == -1) {
				sb.append("Trapped!\n");
			}else {
				sb.append("Escaped in ").append(result).append(" minute(s).\n");
			}
		}
		System.out.println(sb);
	}

	private static int bfs() {
		Queue<Point> queue = new LinkedList();
		queue.add(sp);
		visited[sp.z][sp.x][sp.y]= true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s = 0; s <size; s++) {
				Point now = queue.poll();

				if(now.z == ep.z && now.y == ep.y && now.x == ep.x) {
					return cnt;
				}

				for(int i = 0; i < 6; i++) {
					int nz = now.z + dirs[i][0];
					int nx = now.x + dirs[i][1];
					int ny = now.y + dirs[i][2];

					if(isIn(nz, nx, ny) && !visited[nz][nx][ny]) {
						visited[nz][nx][ny] = true;
						if(map[nz][nx][ny] != '#') {
							queue.add(new Point(nz, nx, ny));
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}

	private static boolean isIn(int nz, int nx, int ny) {
		if(nz >= 0&& nz < L && nx >= 0 && nx < R && ny >=0 && ny < C) {
			return true;
		}
		return false;
	}

}
