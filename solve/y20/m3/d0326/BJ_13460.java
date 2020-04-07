package d0326;

import java.util.Arrays;
import java.util.Scanner;

// 최소 bfs? 가중치 1
public class BJ_13460 {
	public static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1,0}};//왼, 오, 위, 아래
	static int N, M;
	static char[][] map;
	static int ox, oy;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];

		int bx = 0;
		int by = 0;
		int rx = 0;
		int ry = 0;

		result = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'B') {
					bx = i; by = j;
				}else if(map[i][j] == 'R') {
					rx = i; ry = j;
				}else if(map[i][j] == 'O'){
					ox = i; oy = j;
				}
			}
		}

		dfs(bx, by, rx, ry, 0, -1);

		if(result == Integer.MAX_VALUE)
			result = -1;

		System.out.println(result);
	}

	private static void dfs(int bx, int by, int rx, int ry, int cnt, int dir) {	
		if(cnt >= 10) {
			return;
		}

		for(int d = 0; d < 4; d++) {
			if(d == dir) {
				continue;
			}
			//blue부터 움직인다.
			int nbx = bx;
			int nby = by;
			int meet = 0;
			while(map[nbx][nby] != '#') {
				if(map[nbx][nby] == 'O') {//파란색이 나감 -> -1
					meet=1;
					break;
				}else if(map[nbx][nby] == 'R') {
					meet = 2;
				}
				nbx += dirs[d][0];
				nby += dirs[d][1];
			}

			if(meet == 1) {
				continue;
			}

			nbx -= dirs[d][0];
			nby -= dirs[d][1];
			if(meet == 2) {
				nbx -= dirs[d][0];
				nby -= dirs[d][1];
				meet = 0;
			}

			//red움직임
			int nrx = rx;
			int nry = ry;
			boolean bluemeet = false;
			while(map[nrx][nry] != '#') {
				if(map[nrx][nry] == 'O') {//빨간색이 나감 -> cnt+1
					//System.out.println("redout");
					if(result > cnt+1)
						result = cnt+1;
					return;
				}else if(map[nrx][nry] == 'B') {
					bluemeet = true;
				}
				nrx += dirs[d][0];
				nry += dirs[d][1];
			}

			nrx -= dirs[d][0];
			nry -= dirs[d][1];
			if(bluemeet) {
				nrx -= dirs[d][0];
				nry -= dirs[d][1];
				bluemeet = false;
			}


			//			for(int i =0 ; i < N; i++) {
			//				System.out.println(Arrays.toString(map[i]));
			//			}
			//			System.out.println(result);
			map[bx][by] = '.';
			map[nbx][nby] = 'B';
			map[rx][ry] = '.';
			map[nrx][nry] = 'R';
			dfs(nbx, nby, nrx, nry, cnt+1, d);
			map[nbx][nby] = '.';
			map[bx][by] = 'B';
			map[nrx][nry] = '.';
			map[rx][ry] = 'R';


		}
	}

}
