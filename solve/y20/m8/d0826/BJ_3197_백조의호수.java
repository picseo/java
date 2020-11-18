package d0826;

import java.util.*;

public class BJ_3197_백조의호수 {
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
		
		for(int i = 0;; i++) {
			while(!water.isEmpty()) {
				int x = water.poll();
				int y = water.poll();
				map[x][y] = '.';
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dirs[d][0];
					int ny = y + dirs[d][1];
					
					if(!isIn(nx, ny)) continue;
					if(visit[nx][ny]) continue;
					
					if(map[nx][ny] == '.') {
						water.add(nx); water.add(ny);
						visit[nx][ny] = true;
					}else {
						nwater.add(nx); nwater.add(ny);
						visit[nx][ny] = true;
					}
				}
			}
			
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
				System.out.println(i);
				break;
			}
			
			swan = nswan;
			water = nwater;
			nswan = new LinkedList<Integer>();
			nwater = new LinkedList<Integer>();
		}
		
	}
	
	private static boolean isIn(int nx, int ny) {
		if(nx >= 0 && nx < R && ny >=0 && ny < C) {
			return true;
		}
		return false;
	}
}
