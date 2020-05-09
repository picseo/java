package d0508;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2146_다리만들기 {
	static int N, isidx, result;
	static int[][] map;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static class Point{
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		isidx = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					numbering(i, j);
					isidx++;
				}
			}
		}
		result = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] > 0) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(result);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList();
		boolean [][] visited = new boolean[N][N];
		visited[x][y] = true;
		q.add(new Point(x, y));
		int len = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Point now = q.poll();
				
				for(int d= 0; d<4; d++) {
					int nx = now.x + dirs[d][0];
					int ny = now.y + dirs[d][1];
					
					if(isIn(nx, ny) && !visited[nx][ny]) {
						if(map[nx][ny] == 0){
							visited[nx][ny] = true;
							q.add(new Point(nx, ny));
						}else if(map[nx][ny] == map[x][y]) {
							visited[nx][ny] = true;
						}else{
							System.out.println("len : " + len);
							result = (result < len) ? result : len;
							return;
						}
					}
				}
			}
			len++;
		}
		
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >=0 && y < N;
	}
	
	private static void numbering(int i, int j) {
		Queue<Point> q = new LinkedList();
		q.add(new Point(i, j));
		map[i][j] = isidx;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = now.x + dirs[d][0];
				int ny = now.y + dirs[d][1];
				
				if(isIn(nx, ny) && map[nx][ny] == 1) {
					q.add(new Point(nx, ny));
					map[nx][ny] = isidx;
				}
			}
		}
		
	}
	

}
