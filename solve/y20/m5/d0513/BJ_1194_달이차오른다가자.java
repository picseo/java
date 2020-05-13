package d0513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//bfs
public class BJ_1194_달이차오른다가자 {
	static int N, M;
	static char[][] map;
	static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static String karr = "abcdef";
	static String doors = "ABCDEF";
	static List<Integer> es;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		es = new ArrayList<>();
		int sx = 0;
		int sy = 0;

		for(int i = 0; i < N ; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					sx = i;
					sy = j;
					map[i][j] = '.';
				}else if(map[i][j] == '1') {
					es.add(i);
					es.add(j);
					map[i][j] = '.';
				}
			}
		}

		int result = bfs(sx, sy);
		System.out.println(result);
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >=0 && y <M;
	}

	private static int bfs(int sx, int sy) {
		int[][][] visited = new int[N][M][(1<<6)];
		for(int[][] a : visited) {
			for(int[] b : a) {
				Arrays.fill(b, -1);
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(sx); queue.add(sy); queue.add(0);

		int result = 0;
		while(!queue.isEmpty()){
			int size = queue.size()/3;
			for(int i = 0; i < size; i++) {
				int x = queue.poll();
				int y = queue.poll();
				int k = queue.poll();

				for(int d = 0; d < 4; d++) {
					int nx = x + dirs[d][0];
					int ny = y + dirs[d][1];

					if(isIn(nx, ny) && visited[nx][ny][k] == -1 && map[nx][ny] != '#') {
						if(karr.contains(""+map[nx][ny])) {
							visited[nx][ny][k] = result+1;
							int nk = (k | (1<<map[nx][ny]-'a'));
							queue.add(nx);
							queue.add(ny);
							queue.add(nk);
						}else if(doors.contains(""+map[nx][ny])){
							if((k & (1<<map[nx][ny]-'A')) > 0) {
								visited[nx][ny][k] = result+1;
								queue.add(nx);
								queue.add(ny);
								queue.add(k);
							}
						}else {
							visited[nx][ny][k] = result+1;
							queue.add(nx);
							queue.add(ny);
							queue.add(k);
						}
					}

				}

			}
			result++;
		}

		result = -1;
		for(int j = 0; j < es.size()-1; j+=2) {		
			int ex = es.get(j);
			int ey = es.get(j+1);
			for(int i = 0; i < (1<<6); i++) {
				if(visited[ex][ey][i] == -1) continue;
				if(result == -1 || result > visited[ex][ey][i]) {
					result = visited[ex][ey][i];
				}
			}
		}
		return result;		
	}

}
