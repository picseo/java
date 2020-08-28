package d0827;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 적록색약 : R, G를 같게 여긴다.
 *  
 * 구역으로 나눔 -> bfs
 * 
 * 
 */
public class BJ_10026_적록색약 {
	static int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			char[] input = sc.next().toCharArray();
			for(int j = 0; j < N; j++) {
				if(input[j] == 'R') {
					map[i][j] = 1;
				}else if(input[j] == 'G') {
					map[i][j] = 2;
				}else if(input[j] == 'B') {
					map[i][j] = 3;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(1, i, j);
					cnt++;
				}
			}
		}
		
		sb.append(cnt).append(" ");
		cnt = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(0, i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		
		System.out.println(sb.toString());
	}

	private static void bfs(int type, int sx, int sy) {
		Queue<Integer> q = new LinkedList();
		visited[sx][sy] = true;
		q.add(sx);
		q.add(sy);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dirs[d][0];
				int ny = y + dirs[d][1];
				
				if(isIn(nx,ny) && !visited[nx][ny]) {					
					if(type == 1) {
						if(map[x][y] == map[nx][ny]) {
							q.add(nx); q.add(ny);
							visited[nx][ny] = true;
						}
					}else {
						if((map[x][y] < 3 && map[nx][ny] < 3) || 
								(map[x][y] == 3 && map[nx][ny] == 3)) {
							q.add(nx); q.add(ny);
							visited[nx][ny] = true;
						}						
					}
				}
				
			}
			
		}//while
		
	}

	private static boolean isIn(int x, int y) {
		if(x >= 0 && x < N && y >=0 && y < N) {
			return true;
		}
		return false;
	}

}
