package d0401;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/* 가중치 1인 최단 값은 -> bfs
 * 
 * 매번 이동할때 1을 포함하는지 확인하는 것을 H*W 모두 확인하기보다는
 * 이동 방향의 한면만 확인하는게 시간초과가 나지 않게 할 수 있었다.
 *  
 * */
public class BJ_16973_직사각형탈출_BFS {
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

		H = sc.nextInt();
		W = sc.nextInt();
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
						if(nothaveone(nx, ny, d)) {
							queue.add(new Point(nx, ny));
						}
					}
				}
			}
			cnt++;
		}
	}

	static boolean nothaveone(int x, int y, int d) {
		if(d == 0 ) {//위아래
			for(int i = 0; i < W; i++) {
				if(map[x][i+y] == 1) {
					return false;
				}
			}
		}else if(d == 1){
			for(int i = 0; i < W; i++) {
				if(map[x + H -1][i+y] == 1) {
					return false;
				}
			}			
		}else if(d == 2) {//왼오
			for(int i = 0; i < H; i++) {
				if(map[x+i][y] == 1) {
					return false;
				}
			}
		}else if(d == 3) {//왼오
			for(int i = 0; i < H; i++) {
				if(map[x+i][y + W -1] == 1) {
					return false;
				}
			}
		}

		return true;
	}


	static boolean isIn(int x, int y) {
		int lx = x + H -1;
		int ly = y + W -1;

		if(x>= 0 && x < N && y >=0 && y < M) {
			if(lx>= 0 && lx < N && ly >=0 && ly < M) {
				return true;
			}
		}
		return false;
	}

	static boolean notdir(int d, int pred) {
		if(d == 0 && pred == 1) {
			return true;
		}else if(d == 1 && pred == 0) {
			return true;
		}else if(d == 2 && pred == 3) {
			return true;
		}else if(d == 3 && pred == 2) {
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
