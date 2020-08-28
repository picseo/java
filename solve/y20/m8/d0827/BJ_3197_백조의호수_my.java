package d0827;

import java.util.*;

public class BJ_3197_백조의호수_my {
	static int R, C;
	static char[][] map;
	static int sx, sy, ex, ey;
	static boolean[][] visit, svisit;
	
	static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static Queue<Integer> water, nwater, swan, nswan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();

		water = new LinkedList<Integer>();
		nwater = new LinkedList<Integer>();
		swan = new LinkedList<Integer>();
		nswan = new LinkedList<Integer>();
		

		visit = new boolean[R][C];
		svisit = new boolean[R][C];
		
		map = new char[R][C];
		sx = -1;
		
		for(int i =0; i < R; i++) {
			String s = sc.nextLine();
			map[i] = s.toCharArray();
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 'L') {
					if(sx == -1) {
						sx = i;
						sy = j;
					}else {
						ex = i;
						ey = j;
					}
					map[i][j] = '.';
				}			
				
				if(map[i][j] == '.') {
					water.add(i);
					water.add(j);
					visit[i][j] = true;
				}
			}
		}

		swan.add(sx);
		swan.add(sy);
		svisit[sx][sy] = true;
		
		//물과 연결된 얼음 들을 찾아 모은다.
		find();

		int cnt = bfs();

		System.out.println(cnt);
	}

	private static void find() {
		while(!water.isEmpty()) {
			int nowx = water.poll();
			int nowy = water.poll();

			for(int d = 0; d < 4; d++) {
				int nx = nowx + dirs[d][0];
				int ny = nowy + dirs[d][1];

				if(isIn(nx, ny) && !visit[nx][ny]) {
					if(map[nx][ny] == 'X') {
						nwater.add(nx);
						nwater.add(ny);
						visit[nx][ny] = true;
					}					
				}
			}
		}
	}

	private static int bfs() {		
		int cnt = 0;
		while(!nwater.isEmpty()) {
			cnt++;
			int size = nwater.size()/2;
			for(int s = 0 ;s < size; s++) {
				int nowx = nwater.poll();
				int nowy = nwater.poll();
				map[nowx][nowy] = '.';
				
				for(int d = 0; d < 4; d++) {
					int nx = nowx + dirs[d][0];
					int ny = nowy + dirs[d][1];

					if(isIn(nx, ny) && !visit[nx][ny]) {
						if(map[nx][ny] == 'X') {
							nwater.add(nx); nwater.add(ny);
							visit[nx][ny] = true;
						}
					}
				}
			}
			
			/*for(int i = 0; i < R; i++) {
				System.out.println(map[i]);
			}
			System.out.println();*/
			
			while(!swan.isEmpty()) {
				int x = swan.poll();
				int y = swan.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dirs[d][0];
					int ny = y + dirs[d][1];
					
					if(!isIn(nx, ny)) continue;
					if(svisit[nx][ny]) continue;
					
					if(map[nx][ny] == '.') {
						swan.add(nx); swan.add(ny);
						svisit[nx][ny] = true;
					}else {
						nswan.add(nx); nswan.add(ny);
						svisit[nx][ny] = true;
					}
				}
			}
			
			if(svisit[ex][ey]) {
				return cnt;
			}
			
			swan = nswan;
			nswan = new LinkedList();
		}
		return cnt;
	}

	private static boolean isIn(int nx, int ny) {
		if(nx >= 0 && nx < R && ny >=0 && ny < C) {
			return true;
		}
		return false;
	}
}
