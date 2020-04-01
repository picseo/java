package d0330;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 최솟값 이라 같은 방향은 물로 반대 방향도 가지 않아야 한다.
 * 이것을 가지쳐주지 않으면 반복이 너무 많아서 답이 안나온다.
 * */
public class BJ_13460_구슬탈출2 {
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
			
			if(d == 0 && dir == 1) {
				continue;
			}else if(d == 1 && dir == 0) {
				continue;
			}else if(d == 2 && dir == 3) {
				continue;
			}else if(d == 3 && dir == 2) {
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
			
			int nrx = rx;
			int nry = ry;
			boolean bluemeet = false;
			while(map[nrx][nry] != '#') {
				if(map[nrx][nry] == 'O') {
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
			if(nbx == bx && nby == by && nrx == rx && nry == ry) {
			}else {
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

}