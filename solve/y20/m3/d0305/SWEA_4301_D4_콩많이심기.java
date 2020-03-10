package d0305;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * N, M의 값이 커서 고민했는데
 * bfs로 풀리는 문제 였다.
 * 아래 방향으로  bfs를 진행하면서 콩을 둘 수 없는 위치는  queue에 추가하지 않는 방식으로 진행했다.
 * 
 * 1000*1000이더라도 bfs는 O(v+e) -> 최악의 경우 O(V^2)
 * */
public class SWEA_4301_D4_콩많이심기 {
	public static int[][] dirs = {{0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	public static int[][] two_dirs = {{0, 2}, {2, 0}, {0, -2}, {-2, 0}};
	public static boolean[][]visited = null;
	static int n;
	static int m;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			n = sc.nextInt();
			m = sc.nextInt();
			
			visited = new boolean[n+1][m+1];
			result = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m ; j++) {
					if(!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList();
		queue.add(new Node(x, y));
		visited[x][y] = true;
		deletetwo(x, y);
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			result++;			
			for(int i = 0; i < 5; i++) {
				int nx = now.x + dirs[i][0];
				int ny = now.y + dirs[i][1];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						deletetwo(nx, ny);
						queue.add(new Node(nx, ny));
					}
				}
			}
		}
	}
	
	private static void deletetwo(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + two_dirs[i][0];
			int ny = y + two_dirs[i][1];
			
			if(isIn(nx,  ny)) {
				visited[nx][ny] = true;
			}
		}
	}
	
	
	private static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y <m) {
			return true;
		}else {
			return false;
		}
	}
	
	
	private static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}
	
	private static String src = "1\r\n" + 
			"4 4";
}
