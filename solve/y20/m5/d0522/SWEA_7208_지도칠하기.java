package d0522;

import java.util.Scanner;

public class SWEA_7208_지도칠하기 {
	static int N, min;
	static int[] color;
	static boolean[][] connec;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			color = new int[N];
			for(int i = 0; i < N; i++) {
				color[i] = sc.nextInt();
			}
			
			connec = new boolean[N][N];
			for(int i = 0; i < N; i++ ) {
				for(int j = 0; j < N; j++) {
					int input = sc.nextInt();
					if(input == 1) {
						connec[i][j] = true;
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			find(0,0);
			
			System.out.println("#"+t+" "+min);
		}
	}

	private static void find(int idx, int cnt) {
		if(idx == N) {
			if(check()) {
				min = Math.min(cnt,  min);
			}
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			if(color[idx] == i) {
				find(idx+1, cnt);
			}else {
				int tmp = color[idx];
				color[idx] = i;
				find(idx+1, cnt+1);
				color[idx] = tmp;
			}
		}		
	}

	private static boolean check() {
		for(int i = 0; i< N; i++) {
			for(int j = 0; j<N;j++) {
				if(connec[i][j] && color[i] == color[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	

}
