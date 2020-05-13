package d0512;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 이런 문제 나오면 항상 point라는 새로운 class를 만들어서 사용했었는데
 이번 문제에서는 메모리초과가 나왔다.
 
 앞으로는 그냥 이런식으로 진행하는 방법을 익혀야겠다.
 
 그리고 어떤 상황에서는 k의 값을 빼고, 어떤 상황에서는 안빼고 하니까 풀이를 작성하는게 은근 까다롭고 오타가 났다.
 이런점은 경우의 수가 많지 않음면 배열을 만들어서 진행하면 코드가 훨씬 수월해지는 것 같다.
 * */
public class BJ_1600_말이되고픈원숭이 {
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {-1, -2}, {1, -2}};
	static int[] cost = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K, N, M;
		K = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt();

		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}		
		
		int[][][] visited = new int[N][M][K+1];
		for(int[][] a : visited) {
			for(int[] b : a) {
				Arrays.fill(b, -1);
			}
		}
		
		Queue<Integer> q = new LinkedList();
		q.add(0); q.add(0); q.add(K);
		visited[0][0][K] = 0;

		while(!q.isEmpty()) {
			int nowx = q.poll();
			int nowy = q.poll();
			int nowk = q.poll();

//			if(nowk > 0) {
//				for(int d = 4;  d<12; d++) {
//					int nx = nowx + dirs[d][0];
//					int ny = nowy + dirs[d][1];
//
//					if(isIn(nx, ny, N, M) && map[nx][ny] == 0 && visited[nx][ny][nowk-1] == -1) {
//						visited[nx][ny][nowk-1]= visited[nowx][nowy][nowk]+1; 
//						q.add(nx); q.add(ny); q.add(nowk-1);
//					}
//				}
//			}
//
//			for(int d = 0; d < 4; d++) {
//				int nx = nowx + dirs[d][0];
//				int ny = nowy + dirs[d][1];
//
//				if(isIn(nx, ny, N, M) && map[nx][ny] == 0&& visited[nx][ny][nowk] == -1) {
//					visited[nx][ny][nowk]= visited[nowx][nowy][nowk]+1; 
//					q.add(nx); q.add(ny); q.add(nowk);
//				}
//			}
			
			for(int d = 0; d < 12; d++) {
				int nx = nowx + dirs[d][0];
				int ny = nowy + dirs[d][1];
				int nk = nowk - cost[d];
				if(isIn(nx, ny, N, M) && map[nx][ny] == 0) {
					if(nk >= 0 && visited[nx][ny][nk] == -1) {
						visited[nx][ny][nk]= visited[nowx][nowy][nowk]+1; 
						q.add(nx); q.add(ny); q.add(nk);
					}
				}
			}
		}

		int result = Integer.MAX_VALUE;
		for(int i = 0; i <= K; i++) {
			if(visited[N-1][M-1][i] != -1 && visited[N-1][M-1][i] < result) {
				result = visited[N-1][M-1][i];
			}
		}
		
		System.out.println((result)==Integer.MAX_VALUE ? -1 : result);
	}

	static boolean isIn(int x, int y, int N, int M) {
		return x >=0 && x < N && y >= 0 && y <M;
	}
}

/*
1
4 4
0 0 0 0
1 0 0 1
0 0 1 1
0 1 1 0

 * */
