package d0403;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_9659_다항식계산 {
	static int N, M;
	static int[][] tab;
	static long[] xarr;
	static long[][] result;
	static int MOD = 998244353;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = sc.nextInt();
			tab = new int[N+1][3];
			
			for(int i = 2; i <= N; i++) {
				//tab
				tab[i][0] = sc.nextInt();
				tab[i][1] = sc.nextInt();
				tab[i][2] = sc.nextInt();
			}
			
			M = sc.nextInt();
			result = new long[N+1][M];
			
			for(int i = 0; i < M ; i++) {
				result[0][i] = 1;
				result[1][i] = sc.nextLong();
			}
			//#1 2 8 18 32
			for(int i = 2; i <= N; i++) {					
					if(tab[i][0] == 1) {
						for(int j = 0; j < M ; j++) 
							result[i][j] = (result[tab[i][1]][j] + result[tab[i][2]][j])%MOD;
					}else if(tab[i][0] == 2) {
						for(int j = 0; j < M ; j++) 
							result[i][j] = (tab[i][1]*(result[tab[i][2]][j]))%MOD;
					}else if(tab[i][0] == 3) {
						for(int j = 0; j < M ; j++) 
							result[i][j] = (result[tab[i][1]][j] * result[tab[i][2]][j])%MOD;
					}					
			}
			
			for(int i = 0; i < M; i++) {
				sb.append(result[N][i]).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
