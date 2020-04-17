package d0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16137_견우와직녀 {
	static int N, M;
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	static int dirs[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i =0; i < N ; i++) {
			for(int j = 0; j <N ; j++) {
				if(map[i][j] == 0 && ok(i, j)) {
					map[i][j] = M;
					visited = new boolean[N][N][21];
					int time = bfs();
					if(result > time) {
						result = time;
					}
					map[i][j] = 0;
				}
			}
		}

		System.out.println(result);
	}

	private static boolean ok(int x, int y) {
		//가로
		boolean garo = false;
		boolean sero = false;

		if(isIn(x, y+1) && map[x][y+1] == 0) garo = true;
		if(isIn(x, y-1) && map[x][y-1] == 0) garo = true;

		if(isIn(x+1, y) && map[x+1][y] == 0) sero = true;
		if(isIn(x-1, y) && map[x-1][y] == 0) sero = true;

		return !(garo & sero);
	}

	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < N && y >=0 && y < N) {
			return true;
		}
		return false;
	}

	static class Point{
		int x, y, time;

		Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public String toString() {
			return "[" + x + "," + y + ", "+time+"]";
		}

	}

	private static int bfs() {
		Queue<Point> queue = new LinkedList();
		queue.add(new Point(0, 0, 0));
		visited[0][0][0] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0 ; i < size; i++) {
				Point now = queue.poll();
				int x = now.x;
				int y = now.y;

				if(x == N-1 && y == N-1) {
					return cnt;
				}

				if(map[x][y] >= 2 && cnt%(map[x][y]) != 0) {
					int nt = (cnt+1)%map[x][y];
					if(!visited[x][y][nt]) {
						visited[x][y][nt] = true;
						queue.add(new Point(x, y, nt));
					}
				}else {
					for(int d = 0; d < 4; d++) {
						int nx = x + dirs[d][0];
						int ny = y + dirs[d][1];

						if(isIn(nx, ny)) {
							if(map[x][y] >= 2 && map[nx][ny] >= 2)
								continue;

							
							if((map[nx][ny]) >=1) {
								int nt = (cnt + 1)%map[nx][ny];
								if(!visited[nx][ny][nt]) {
								visited[nx][ny][nt] = true;
								queue.add(new Point(nx, ny, nt));
								}
							}
						}
					}
				}
			}
			cnt++;
		}		
		return Integer.MAX_VALUE;
	}
}