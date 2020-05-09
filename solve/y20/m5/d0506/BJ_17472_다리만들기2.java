package d0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
//bfs + mst

public class BJ_17472_다리만들기2 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Point> pq;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int result = 0;
	
	static class Point implements Comparable<Point>{
		int x, y;
		int len;
		Point(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
		@Override
		public int compareTo(Point o) {
			return this.len - o.len;
		}		
	}
	
	static boolean isIn(int x, int y) {
		if(x >= 0 && x < N &&  y>=0 && y < M) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		//N = sc.nextInt();
		//M = sc.nextInt();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<Point>();
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				//map[i][j] = sc.nextInt();
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean out = false;
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					out = true;
					break;
				}
			}
			if(out)
				break;
		}
		
		while(!pq.isEmpty()) {
			Point next = pq.poll();
			if(!visited[next.x][next.y]) {
				result += next.len;
				bfs(next.x, next.y);
			}
		}
		
		out = false;
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					out = true;
					result = -1;
					break;
				}
			}
			if(out)
				break;
		}
		
		System.out.println(result);
	}

	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList();
		visited[i][j] = true;
		q.add(new Point(i, j, 0));
		
		check(i, j);//다리가 존재하는 지 고려하기
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int d = 0; d < 4; d++) {
				int nx = now.x + dirs[d][0];
				int ny = now.y + dirs[d][1];
				
				if(isIn(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny, 0));
					check(nx, ny);
				}
			}
		}				
	}

	private static void check(int x, int y) {
		//섬의 각 점에서 다리를 놓을 수 있다면, pq에 추가해준다.
		
		for(int d = 0; d < 4; d++) {
			//섬을 만나거나 범위를 벗어나기 직전까지 진행
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];
			int len = 0;
			
			while(isIn(nx, ny)) {
				if(map[nx][ny] == 1) {//섬이고
					if(visited[nx][ny]) {//이미 방문했다면 더이상 확인할 필요없음
						break;
					}else {//아직 방문하지 않은 곳이면
						if(len >= 2) {//길이가 1인건 무시
							pq.add(new Point(nx, ny, len));
						}
						break;
					}
				}
				
				nx += dirs[d][0];
				ny += dirs[d][1];
				len++;
			}
		}
		
	}
	
	

}
