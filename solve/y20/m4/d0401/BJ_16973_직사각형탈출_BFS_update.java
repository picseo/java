package d0401;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/* 가중치 1인 최단 값은 -> bfs
 * 
 * 
 * */
public class BJ_16973_직사각형탈출_BFS_update {
	static int N, M, H, W, sx, sy, fx, fy;
	static int[][] map;
	static boolean[][] visited;

	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//위, 아래, 왼, 오
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		System.out.println();
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		H = sc.nextInt();
		W = sc.nextInt();
		
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					//1이 겹치게 되는 부분을 visit처리해준다. -> 이 과정을 통해 haveone함수를 매번 실행하지 않아도 된다.
					for(int ii = 0; ii < H; ii++) {
						for(int ij = 0; ij < W; ij++) {
							if(i-ii >=0 && j-ij >= 0)
								visited[i-ii][j-ij] = true;
						}
					}
					
				}
			}
		}
		
		System.out.println();
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		
		sx = sc.nextInt() -1;
		sy = sc.nextInt() -1;
		fx = sc.nextInt() -1;
		fy = sc.nextInt() -1;

		result = Integer.MAX_VALUE;
		bfs(sx, sy);

		if(result == Integer.MAX_VALUE) {
			result = -1;
		}

		System.out.println(result);
	}


	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList();
		queue.add(new Point(x, y));
		visited[x][y] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i =0 ; i < size; i++) {
				Point now = queue.poll();

				if(fx == now.x && fy == now.y) {
					result = cnt;
					return;
				}
				
				for(int d = 0; d < 4; d++) {
					int nx = now.x + dirs[d][0];
					int ny = now.y + dirs[d][1];

					if(isIn(nx, ny) && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new Point(nx, ny));
					}
				}
			}
			cnt++;
		}
	}

//	static boolean nothaveone(int x, int y, int d) {
//		if(d == 0 ) {//위아래
//			for(int i = 0; i < W; i++) {
//				if(map[x][i+y] == 1) {
//					return false;
//				}
//			}
//		}else if(d == 1){
//			for(int i = 0; i < W; i++) {
//				if(map[x + H -1][i+y] == 1) {
//					return false;
//				}
//			}			
//		}else if(d == 2) {//왼오
//			for(int i = 0; i < H; i++) {
//				if(map[x+i][y] == 1) {
//					return false;
//				}
//			}
//		}else if(d == 3) {//왼오
//			for(int i = 0; i < H; i++) {
//				if(map[x+i][y + W -1] == 1) {
//					return false;
//				}
//			}
//		}
//
//		return true;
//	}


	static boolean isIn(int x, int y) {
		int lx = x + H -1;
		int ly = y + W -1;

//		if(x>= 0 && x < N && y >=0 && y < M) {
//			if(lx>= 0 && lx < N && ly >=0 && ly < M) {
//				return true;
//			}
//		}
		//-->이렇게 줄일 수 있다.
		if(x >= 0 && x + H -1 < N && y >=0 && y +W -1 < M) {
			return true;
		}
		return false;
	}


	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
