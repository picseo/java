package d0414;

import java.util.Arrays;
import java.util.Scanner;
//처음에는 다 0인 경우 result 값을 바꿔주는 처리가 없어서 틀렸다.
//0인 경우도 생각하자!!
public class BJ_15683_감시 {
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int[][][] nd = {{{0, 1}, {2, 3}, {0, 1}, {2, 3}}, {{3, 0}, {0, 2}, {2, 1}, {1, 3}}, 
			{{0, 1, 3},{2, 3, 0},{0, 1, 2},{2, 3, 1}}};
	static int N, M, result, nums;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = 0;
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] != 0 && map[i][j] != 6) {
					nums++;
				}
			}
		}
		
		result = Integer.MAX_VALUE;
		find(0, 0, map, 0);
		
		System.out.println(result);
	}

	private static void find(int x, int y, int[][] tmp, int cnt) {
		if(cnt == nums) {
			int sgjd = 0;
			for(int i = 0; i < N; i++) {
				//System.out.println(Arrays.toString(tmp[i]));
				for(int j =0; j < M; j++) {
					if(tmp[i][j] == 0) {
						sgjd++;
					}
				}
			}
			//System.out.println();
			if(result > sgjd) {
				result = sgjd;
			}
			return ;
		}
		
		for(int i = x; i < N; i++) {
			for(int j = y; j < M; j++) {
				if(tmp[i][j] == 0 || tmp[i][j] == 6 || tmp[i][j] == -1) {
					continue;
				}
				
				if(tmp[i][j] == 5) {
					int[][] ttmp = new int[N][M];
					for(int t = 0; t < N; t++) {
						ttmp[t] = tmp[t].clone();
					}
					fill_tmp(i, j, 5, 0, ttmp);
					find(i, j+1, ttmp, cnt+1);
				}else {
					for(int d = 0; d < 4; d++) {
						int[][] ttmp = new int[N][M];
						for(int t = 0; t < N; t++) {
							ttmp[t] = tmp[t].clone();
						}
						fill_tmp(i, j, tmp[i][j], d, ttmp);
						find(i, j+1, ttmp, cnt+1);
					}
				}
			}
			y = 0;
		}
		
	}

	private static void fill_tmp(int x, int y, int k, int d, int[][] tmp) {
		if(k == 1) {
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];
			while(isIn(nx, ny) && tmp[nx][ny] != 6) {
				if(tmp[nx][ny] == 0)
					tmp[nx][ny] = -1;
				nx += dirs[d][0];
				ny += dirs[d][1];
			}
		}else if(k == 2 || k == 3||k == 4) {
				int innersize = nd[k-2][d].length;
				for(int in = 0; in <innersize; in++) {
					int dd = nd[k-2][d][in];
					int nx = x + dirs[dd][0];
					int ny = y + dirs[dd][1];
					while(isIn(nx, ny) && tmp[nx][ny] != 6) {
						if(tmp[nx][ny] == 0)
							tmp[nx][ny] = -1;
						nx += dirs[dd][0];
						ny += dirs[dd][1];
					}
				}
		}else if(k == 5) {
			for(int i = 0; i < 4; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];
				while(isIn(nx, ny)&& tmp[nx][ny] != 6) {
					if(tmp[nx][ny] == 0)
						tmp[nx][ny] = -1;
					nx += dirs[i][0];
					ny += dirs[i][1];
				}
			}
		}		
	}
	
	private static boolean isIn(int x, int y) {
		if(x >=0 && x < N &&  y >= 0 && y< M) {
			return true;
		}
		return false;
	}
}
