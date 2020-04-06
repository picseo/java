package d0406;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 완탐이고
 * 완탐을 하면서 같은 칸에 한번 이상 도달하는 경우는 무시
 * 
 * */
public class BJ_1405_미친로봇 {
	static int N;
	static double[] ewsn = new double[4];
	static double result =0 ;
	static boolean[][] check = new boolean[30][30];
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i = 0; i < 4; i++) {
			ewsn[i] = (double)((sc.nextInt())*0.01);
		}
		
		System.out.println(Arrays.toString(ewsn));
		int x = 14;
		int y = 14;
		check[x][y] = true;
		dfs(0, 1.0, x, y);
		check[x][y] = false;
		
		System.out.println(result);
	}

	private static void dfs(int cur, double d, int x, int y) {
		if(cur == N) {
			result += d;
			return ;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			
			if(nx < 0 || nx >= 30 || ny < 0 || ny >= 30) {
				continue;
			}
			
			if(check[nx][ny]) {//중복되었다면
				continue;
			}else {//중복되지 않았다면 진행
				check[nx][ny] = true;
				dfs(cur+1, d*ewsn[i], nx, ny);
				check[nx][ny] = false;
			}
		}
		
	}

}
