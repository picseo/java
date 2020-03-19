package d0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_14499 {
	public static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};//µ¿, ¼­, ºÏ, ³²
	static int N, M;
	static int[][] map;
	static int[] dice = {0,0,0,0,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken())-1;
			int nx = x + dirs[dir][0];
			int ny = y + dirs[dir][1];
			if(isIn(nx, ny)) {
				if(dir == 0) {
					int tmp = dice[0];
					dice[0] = dice[2];
					dice[2] = dice[5];
					dice[5] = dice[3];
					dice[3] = tmp;					
				}else if(dir == 1) {
					int tmp = dice[0];
					dice[0] = dice[3];
					dice[3] = dice[5];
					dice[5] = dice[2];
					dice[2] = tmp;
				}else if(dir == 2) {
					int tmp = dice[0];
					dice[0] = dice[4];
					dice[4] = dice[5];
					dice[5] = dice[1];
					dice[1] = tmp;
				}else if(dir == 3) {
					int tmp = dice[0];
					dice[0] = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[4];
					dice[4] = tmp;
				}
				
				if(map[nx][ny] != 0) {
					dice[0] = map[nx][ny];
					map[nx][ny] = 0;
				}else {
					map[nx][ny] = dice[0];
				}
				
				sb.append(dice[5]).append("\n");
				
				x = nx;
				y = ny;
			}
		}
		
		System.out.println(sb);
	}

	public static boolean isIn(int x, int y) {
		if(x >=0 && x <N && y>=0 && y <M) {
			return true;
		}else {
			return false;
		}
	}
	
	
	private static String src = "3 3 0 0 16\r\n" + 
			"0 1 2\r\n" + 
			"3 4 5\r\n" + 
			"6 7 8\r\n" + 
			"4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2";
}
