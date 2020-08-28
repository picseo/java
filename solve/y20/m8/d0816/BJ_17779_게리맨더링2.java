package d0816;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_17779_게리맨더링2 {
	static int N;
	static int[][] value;
	static int[] cnt;
	static int[][] check;
	//x = row, y = col
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		value = new int[N+1][N+1];
		check = new int[N+1][N+1];
		cnt = new int[5];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				value[i][j] = sc.nextInt();
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= N; y++) {
				for(int d1 = 1; d1 <= N; d1++) {
					for(int d2 = 1; d2 <= N; d2++) {
						int tmp = find(x, y, d1, d2);
						if(tmp == -1)
							break;
						if(tmp != -1 && tmp < result)
							result = tmp;
					}
				}
			}
		}
		//find(4, 3, 1, 1);
		
		System.out.println(result);
	}

	private static int find(int x, int y, int d1, int d2) {
		//1 ~ 4 구역 표시
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i >= 1 && i < x + d1 && j >= 1 && j <= y) {
					check[i][j] = 1;
				}
				if(i >= 1 && i <= x + d2 && j > y && j <= N) {
					check[i][j] = 2;
				}
				if(i >= x+d1 && i <= N && j >=1 && j < y -d1 +d2) {
					check[i][j] = 3;
				}
				if(i > x+d2 && i <= N && j >= y-d1+d2 && j <= N) {
					check[i][j] = 4;
				}
			}
		}
		
		/*for(int i = 1; i <= N; i++) {
			for(int j =1; j <= N; j++) {
				System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();*/
		
		//5구역 표시
		int Ly= 0;
		int Ry = 0;
		for(int i = 0; i <= d1+d2; i++) {//x위치
			for(int j = Ly; j <= Ry; j++) {
				int now = y + j;
				int nowx = x + i;
				if(isIn(nowx, now)) {
					check[nowx][now] = 5;
				}else {
					return -1;
				}
			}
			
			if(i < d1) {
				Ly--;
			}else {
				Ly++;
			}
			
			if(i < d2) {
				Ry++;
			}else {
				Ry--;
			}
		}
		
		
		/*for(int i = 1; i <= N; i++) {
			for(int j =1; j <= N; j++) {
				System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		Arrays.fill(cnt, 0);
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				cnt[check[i][j]-1] += value[i][j];
			}
		}
		
		Arrays.sort(cnt);
		//System.out.println(Arrays.toString(cnt));
		return Math.abs(cnt[4] - cnt[0]);
		//return 0;
	}
	
	private static boolean isIn(int x, int y) {
		if(x >= 1 && x <= N && y >= 1 && y <= N) {
			return true;
		}
		return false;
	}

}
