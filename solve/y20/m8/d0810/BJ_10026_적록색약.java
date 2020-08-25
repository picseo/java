package d0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//다른 사람들은 dfs를 이용해서 풀었는데, 더 시간이 적게 걸린다.
//bfs를 이용했고, 색약이 있는 경우는 boolean값을 이용해서 check할때 R, G가 같은 색으로 인식할 수 있도록 만들었다.
public class BJ_10026_적록색약 {
	static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int N;
	static char[][] map = new char[101][101];
	static boolean[][] visited = new boolean[101][101];
	
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		
		for(int i = 0;i < N; i++) {
			String line = input.readLine();
			map[i] = line.toCharArray();
		}
		
		int result1 = 0;
		for(int i = 0; i < N ;i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					result1++;
					bfs(true, i, j);
				}
			}
		}
		
		for(int i = 0; i < 101; i++) {
			Arrays.fill(visited[i], false);
		}
		
		int result2 = 0;
		for(int i = 0; i < N ;i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					result2++;
					bfs(false, i, j);
				}
			}
		}
		
		System.out.println(result1 + " " + result2);
		
	}

	private static void bfs(boolean ok, int sx, int sy) {
		Queue<Integer> queue = new LinkedList();
		queue.add(sx);
		queue.add(sy);
		visited[sx][sy] = true;
		
		while(!queue.isEmpty()) {
			int tx = queue.poll();
			int ty = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = tx + dirs[i][0];
				int ny = ty + dirs[i][1];
				
				if(isIn(nx, ny) && !visited[nx][ny] && check(nx, ny, map[tx][ty], ok)) {
					queue.add(nx);
					queue.add(ny);
					visited[nx][ny] = true;
				}
			}	
		}
	}

	private static boolean isIn(int nx, int ny) {
		if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}
	
	private static boolean check(int nx, int ny, char color, boolean ok) {
		if(map[nx][ny] == color) {
			return true;
		}else {
			if(!ok) {
				if(map[nx][ny] == 'R' && color == 'G') {
					return true;
				}
				if(map[nx][ny] == 'G' && color == 'R') {
					return true;
				}
			}
		}
		return false;
	}
	
}
