package d0826;

import java.util.Scanner;

public class BJ_2210_숫자판점프 {
	static int[][] map = new int[5][5];
	static boolean[][][][][][] visit = new boolean[10][10][10][10][10][10];
	
	static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				int[] tmp = new int[6];
				tmp[0] = map[i][j];
				
				find(i, j, 1, tmp);
			}
		}
		
		System.out.println(result);
	}

	private static void find(int x, int y, int k, int[] t) {
		if(k == 6) {
			if(!visit[t[0]][t[1]][t[2]][t[3]][t[4]][t[5]]) {
				visit[t[0]][t[1]][t[2]][t[3]][t[4]][t[5]] = true;
				result++;
			}
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];
			
			if(isIn(nx, ny)) {
				t[k] = map[nx][ny];
				find(nx, ny, k+1, t);
			}
		}
		
	}

	private static boolean isIn(int nx, int ny) {
		if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
			return true;
		}
		return false;
	}
	
	

}
