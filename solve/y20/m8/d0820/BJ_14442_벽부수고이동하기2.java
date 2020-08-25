package d0820;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 
 먼저 부술 벽을 0 ~ 10개를 선택 후
 bfs를 진행한다. (최단경로구하는게 목표이므로) 
 */
public class BJ_14442_벽부수고이동하기2 {
	static int N, M, K;
	static int[][] map;
	static int[][] tmp_map;
	static boolean[][] visited;

	static int result = -1;
	static int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();

		map = new int[N][M];
		tmp_map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String input = sc.nextLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}

		//벽을 부순다.
		for(int k = 0; k <= K; k++) {
			for(int i =0 ; i < N; i++) {
				tmp_map[i] = map[i].clone();
			}

			crush(0, k);
		}

		System.out.println(result);
	}

	private static void crush(int idx, int k) {		
		if(k == 0) {
			visited = new boolean[N][M];
			bfs(0, 0);
			return;
		}

		if(idx == N*M && k !=0) {
			return;
		}

		int x = idx/M;
		int y = idx%M;

		if(tmp_map[x][y] == 1) {
			tmp_map[x][y] = 0;
			crush(idx+1, k-1);
			tmp_map[x][y] = 1;
		}

		crush(idx+1, k);
	}

	private static void bfs(int x, int y) {
		Queue<Integer>q = new LinkedList();

		q.add(x);
		q.add(y);
		visited[x][y] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size()/2;
			for(int s = 0; s < size; s++) {
				int nowx = q.poll();
				int nowy = q.poll();

				for(int d = 0; d <4 ;d++) {
					int nx = nowx + dirs[d][0];
					int ny = nowy + dirs[d][1];

					if(isIn(nx, ny) && !visited[nx][ny] && tmp_map[nx][ny] == 0) {
						q.add(nx);
						q.add(ny);
						visited[nx][ny] = true;
						
						if(nx == N-1 && ny == M-1) {
							if(result == -1 || result > cnt) {
								result = cnt;
							}
						}
					}
				}
			}			
		}
	}

	private static boolean isIn(int nx, int ny) {
		if(nx >= 0 && nx < N && ny >=0 && ny < M) {
			return true;
		}
		return false;
	}

}
