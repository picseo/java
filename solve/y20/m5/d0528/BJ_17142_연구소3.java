package d0528;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//0이랑 2를 다르게 해야하는 방법을 어떻게 구현해야할지몰랐다.
public class BJ_17142_연구소3 {
	//(4<=N<=50), (1<=M<=10)
	//bfs, 조합
	static int N, M, count, result;
	static int[][] visited;
	static int[][] map;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static List<Point> viruses;
	static boolean[] select;
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new int[N][N];
		map = new int[N][N];
		
		count = 0;
		viruses = new ArrayList();
		result = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					viruses.add(new Point(i, j));
				}
				if(map[i][j] ==0) {
					count++;
				}
			}
		}
		
		select = new boolean[viruses.size()];
		dfs(0, viruses.size(), 0);
		
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}

	private static void dfs(int now, int size, int cnt) {
		if(now > size || cnt > M) {
			return;
		}
		
		if(now >= size && cnt < M) {
			return;
		}
		
		if(cnt == M) {
			for(int i = 0; i < N ; i++) {
				Arrays.fill(visited[i], -1);
			}
			bfs();
			return;
		}		
		
			select[now] = true;
			dfs(now+1, size, cnt+1);
			select[now] = false;
			dfs(now+1, size, cnt);
	}

	private static void bfs() {
		int cnt = 0;
		Queue<Point> q = new LinkedList<Point>();
		for(int i = 0; i < viruses.size(); i++) {
			Point now = viruses.get(i);
			if(select[i]) {
				q.add(viruses.get(i));
				visited[now.x][now.y]= 0; 
			}
		}
		
		int tmp = 0;
		while(!q.isEmpty()) {
				Point now = q.poll();
				for(int i = 0; i < 4; i++) {
					int nx = now.x + dirs[i][0];
					int ny = now.y + dirs[i][1];
					
					if(isIn(nx, ny) && map[nx][ny] != 1 && visited[nx][ny] == -1) {
						visited[nx][ny] = visited[now.x][now.y] + 1;
						if(map[nx][ny] == 0) {
							tmp = visited[nx][ny];
							cnt++;
						}
						q.add(new Point(nx, ny));					
					}
				}
		}
		
		if(cnt == count) {			
			result = Math.min(tmp,  result);
		}
	}

	private static boolean isIn(int x, int y) {
		return x >=0 && x < N && y >=0 && y < N;
	}
}
