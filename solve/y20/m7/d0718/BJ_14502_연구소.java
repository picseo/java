package d0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//N, M이 작으므로 모든 경우의 수를 고려할 것이다.
// 1을 3개 추가하는 경우를 모두 만든다음에 
//각각 bfs를 돌려서 안전영역을 구하면 된다.

public class BJ_14502_연구소 {
	static int N, M, result, total0;
	static int[][] map;
	static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	static ArrayList<Integer> twos = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		result = 0;
		total0=0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					twos.add(i);
					twos.add(j);
				}
				if(map[i][j] == 0) {
					total0++;
				}
			}
		}
		
		//3개 벽을 세운다. -> 3개가 세워지면 채워본다 -> 안전영역의 크기를 구한다.
		fill_map(0, 3);
		
		System.out.println(result);
	}


	private static void fill_map(int num, int cnt) {
		int x= num/M;
		int y = num%M;
		
		if(cnt == 0) {
			int[][] tmp_map = new int[N][M];
			for(int i =0 ; i < N; i++) {
				tmp_map[i] = map[i].clone();
			}
			
			bfs(tmp_map);
			return;
		}
		
		if(num >= N*M) {
			return;
		}
		//0을 채움
		if(map[x][y] == 0) {
			map[x][y] = 1;
			fill_map(num+1, cnt-1);
			map[x][y] = 0;
			fill_map(num+1, cnt);
		}else {
			fill_map(num+1, cnt);
		}
	}
	
	private static void bfs(int[][] tmp_map) {
		boolean[][] visited = new boolean[N][M];
		int changed = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int item : twos) {
			queue.add(item);
		}
		
		int tmp = 0;
		while(!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			tmp ++;
			
			for(int d =0; d< 4; d++) {
				int nx = x + dirs[d][0];
				int ny = y + dirs[d][1];
				
				if(isIn(nx, ny) && !visited[nx][ny] && tmp_map[nx][ny] == 0) {
					visited[nx][ny] = true;
					tmp_map[nx][ny] = 2;
					changed++;
					queue.add(nx);
					queue.add(ny);
				}
			}
		}
		
		if((total0 - changed-3) > result) {
			result = total0 - changed-3;
		}
	}


	private static boolean isIn(int x, int y) {
		if(x >=0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}

}
