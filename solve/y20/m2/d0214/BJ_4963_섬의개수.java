package swea.d0214;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_4963_섬의개수 {
	private static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int c = sc.nextInt();
		int r = sc.nextInt();
		
		while(c != 0 && r != 0) {
			int[][] map = new int[r][c];
			for(int i =0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int result = 0;
			for(int i = 0 ; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(map[i][j] == 0) {
						continue;
					}else {
						result++;
						Queue<point> que = new LinkedList();
						que.add(new point(i, j));
						map[i][j] = 0;
						while(!que.isEmpty()) {
							point now = que.poll();
							
							for(int dir = 0; dir < 8; dir++) {
								int nx = now.x + dirs[dir][0];
								int ny = now.y + dirs[dir][1];
								
								if(isIn(nx, ny, r, c) && map[nx][ny] == 1) {
									map[nx][ny] = 0;
									que.add(new point(nx, ny));
								}
							}							
							
						}
						
					}
				}
			}
			
			System.out.println(result);
			c = sc.nextInt();
			r = sc.nextInt();
		}
	}

	static class point{
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static boolean isIn(int x, int y, int r, int c) {
		if(x >= 0 && x < r && y >= 0 && y < c) {
			return true;
		}else {
			return false;
		}
	}
	
	private static String src = "1 1\r\n" + 
			"0\r\n" + 
			"2 2\r\n" + 
			"0 1\r\n" + 
			"1 0\r\n" + 
			"3 2\r\n" + 
			"1 1 1\r\n" + 
			"1 1 1\r\n" + 
			"5 4\r\n" + 
			"1 0 1 0 0\r\n" + 
			"1 0 0 0 0\r\n" + 
			"1 0 1 0 1\r\n" + 
			"1 0 0 1 0\r\n" + 
			"5 4\r\n" + 
			"1 1 1 0 1\r\n" + 
			"1 0 1 0 1\r\n" + 
			"1 0 1 0 1\r\n" + 
			"1 0 1 1 1\r\n" + 
			"5 5\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 0";
}
