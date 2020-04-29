package d0414;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_3184_양 {
	static int R, C;
	static char[][] map;
	static int resa, resb;
	static boolean[][] visited;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < C; j++) {
				if(map[i][j] == '#') {
					visited[i][j] = true;
				}				
			}
		}

		resa = 0;
		resb = 0;
		
		for(int i = 0; i < R; i++) {
			for(int j =0; j < C; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(resa + " " + resb);
	}

	private static void bfs(int x, int y) {
		Queue<Integer> queue = new LinkedList();
		
		visited[x][y] = true;
		queue.add(x);
		queue.add(y);
		int tmpa = 0;//양
		int tmpb = 0;//늑대
		
		while(!queue.isEmpty()) {
			int nowx = queue.poll();
			int nowy = queue.poll();
			
			if(map[nowx][nowy] == 'v') {
				tmpb++;
			}else if(map[nowx][nowy] == 'o'){
				tmpa++;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = nowx + dirs[i][0];
				int ny = nowy + dirs[i][1];
				
				if(isIn(nx, ny)) {
					if(visited[nx][ny]) {
						continue;
					}
					
					visited[nx][ny] = true;
					queue.add(nx);
					queue.add(ny);					
				}
			}
			
		}
		
		if(tmpb < tmpa) {
			resa += tmpa;
		}else {
			resb += tmpb;
		}
	}
	
	private static boolean isIn(int x, int y) {
		if(x < 0 || x >= R || y <0 || y >= C) {
			return false;
		}
		return true;
	}
	

}
