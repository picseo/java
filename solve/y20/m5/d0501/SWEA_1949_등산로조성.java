package d0501;

import java.util.Scanner;
//다음으로 진행하기 위해 K까지 뺄 수 있을 때 결국 최대값을 구하려면 현재 map[i][j] -1로 다음 값을 만드는게 최적이다.
public class SWEA_1949_등산로조성 {
	static int N, K;
	static int[][] map;
	static int result = 0;
	static int Max = 0;
	static int[][] dirs= {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//우, 왼, 하, 위
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1;t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			
			//입력과 큰 값 찾기
			Max= 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N ; j++) {
					map[i][j] = sc.nextInt();
					if(Max < map[i][j]) {
						Max = map[i][j];
					}
				}
			}
			
			result = -1;
			for(int i = 0; i < N ; i++) {
				for(int j = 0; j < N ;j++) {
					if(map[i][j] == Max) {
						dfs(i, j, -1, map[i][j], true, 1);
					}
				}
			}
			
			sb.append("#"+t+" ").append(result).append("\n");
		}
		System.out.println(sb);
	}//main
	
	private static void dfs(int x, int y, int pre_d , int pre, boolean check, int len) {
		boolean stop = true;
		for(int d = 0; d < 4; d++) {//우, 왼, 하, 위
			if((d == 0 && pre_d == 1) || (d == 1 && pre_d ==0) || (d==2 && pre_d==3) || (d==3 && pre_d ==2)) {
				continue;//이전으로 돌아가지 않음
			}
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];
			
			if(isIn(nx, ny)) {
				if(map[nx][ny] >= pre) {//내려갈 수 없음(깎아야 함)
					if(check) {
						if(map[nx][ny]-K < pre) {
							stop = false;
							dfs(nx, ny, d, map[x][y]-1, false, len+1);
						}
//						for(int i = 1; i <= K; i++) {
//							if(map[nx][ny] - i < pre) {
//								stop = false;
//								dfs(nx, ny, d, map[nx][ny] - i,false, len+1);
//							}
//						}
					}
				}else {//내려갈 수 있음
					stop = false;
					dfs(nx, ny, d, map[nx][ny], check, len+1);
				}
			}
		}
		
		if(stop) {
			if(result < len) {
				result = len;
				return;
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		if(x >= 0  && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
	
}
