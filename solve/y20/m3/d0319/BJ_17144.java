package d0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17144 {
	static int N, M, T;
	static int[][] map, tmp;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] dirs_down = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int[][] dirs_up = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		int idx = 0;
		int[] air = new int[2];
		tmp = new int[N][M];
		map = new int[N][M];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					air[idx++] = i;
				}
			}
		}
		
		for(int t = 0; t < T; t++) {
			tmp = new int[N][M];
			//미세먼지의 확산
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <M; j++) {
					if(map[i][j] != 0) {
						int small = map[i][j]/5;
						if(small < 1) {
							tmp[i][j] += map[i][j];	
							continue;
						}
						for(int d = 0; d < 4; d++) {
							int nx = i + dirs[d][0];
							int ny = j + dirs[d][1];

							if(isIn(nx, ny) && map[nx][ny] != -1) {
								tmp[nx][ny] += small;
								map[i][j] -= small;
							}							
						}
						tmp[i][j] += map[i][j];						
					}
				}
			}
			
			//바람을 분다.
			//1.up
			int x = air[0];
			int pre = 0;
			for(int y = 1; y < M; y++) {
				int now = tmp[x][y];
				tmp[x][y] = pre;
				pre = now;
			}

			int y = M-1;
			for(x= air[0]-1; x >=0; x--) {
				int now = tmp[x][y];
				tmp[x][y] = pre;
				pre = now;
			}

			x = 0;
			if(air[0] != 0) {
				for(y = M-2; y >=0 ; y--) {
					int now = tmp[x][y];
					tmp[x][y] = pre;
					pre = now;
				}

				y =0;
				for(x= 1; x < air[0]; x++) {
					int now = tmp[x][y];
					tmp[x][y] = pre;
					pre = now;
				}
			}

			//down
			x = air[1];
			pre = 0;
			for(y = 1; y < M; y++) {
				int now = tmp[x][y];
				tmp[x][y] = pre;
				pre = now;
			}

			y = M-1;
			for(x= air[1]+1; x <N; x++) {
				int now = tmp[x][y];
				tmp[x][y] = pre;
				pre = now;
			}

			x = N-1;
			if(air[1] != N-1) {
				for(y = M-2; y >=0 ; y--) {
					int now = tmp[x][y];
					tmp[x][y] = pre;
					pre = now;
				}

				y =0;
				for(x= N-2; x > air[1]; x--) {
					int now = tmp[x][y];
					tmp[x][y] = pre;
					pre = now;
				}			
			}
			map = tmp.clone();
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0) {
					result+= map[i][j];
				}
			}
		}

		System.out.println(result);
	}

	static boolean isIn(int x, int y) {
		if(x>=0 && x < N && y >=0 && y <M) {
			return true;
		}else {
			return false;
		}
	}

	static String src = "7 8 30\r\n" + 
			"0 0 0 0 0 0 0 9\r\n" + 
			"0 0 0 0 3 0 0 8\r\n" + 
			"-1 0 5 0 0 0 22 0\r\n" + 
			"-1 8 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 10 43 0\r\n" + 
			"0 0 5 0 15 0 0 0\r\n" + 
			"0 0 40 0 0 0 20 0";
}
