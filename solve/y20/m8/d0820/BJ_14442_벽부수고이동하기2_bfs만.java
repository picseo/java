package d0820;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 
 bfs를 진행하면서 벽을 부순다.(벽을 부순 정보도 저장해야하므로 3차원 배열을 이용) (최단경로구하는게 목표이므로) 
 */
public class BJ_14442_벽부수고이동하기2_bfs만 {
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;

	static int result = -1;
	static int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();

		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		
		for(int i = 0; i < N; i++) {
			String input = sc.nextLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}

		bfs(0, 0, K);
		System.out.println(result);
	}

	private static void bfs(int x, int y, int k) {
		Queue<Integer>q = new LinkedList();

		q.add(x);
		q.add(y);
		q.add(k);
		
		visited[x][y][k] = true;
		int cnt = 1;
		
		if(x == N-1 && y == M-1) {
			if(result == -1 || result > cnt) {
				result = cnt;
			}
		}
		
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size()/3;
			for(int s = 0; s < size; s++) {
				int nowx = q.poll();
				int nowy = q.poll();
				int nowk = q.poll();
				
				for(int d = 0; d <4 ;d++) {
					int nx = nowx + dirs[d][0];
					int ny = nowy + dirs[d][1];
					
					if(isIn(nx, ny)) {
						if(map[nx][ny] == 1 && nowk > 0) {
							if(!visited[nx][ny][nowk-1]) {
								q.add(nx);
								q.add(ny);
								q.add(nowk-1);
								visited[nx][ny][nowk-1] = true;
							}
						}
						
						if(map[nx][ny] == 0) {
							if(!visited[nx][ny][nowk]) {
								q.add(nx);
								q.add(ny);
								q.add(nowk);
								visited[nx][ny][nowk] = true;
								if(nx == N-1 && ny == M-1) {
									if(result == -1 || result > cnt) {
										result = cnt;
									}
								}
							}
						}
						
					}
					
				}//for d
				
			}//for s
		}//while
		
	}

	private static boolean isIn(int nx, int ny) {
		if(nx >= 0 && nx < N && ny >=0 && ny < M) {
			return true;
		}
		return false;
	}

}
