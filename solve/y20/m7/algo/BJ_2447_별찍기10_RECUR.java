package algo;

import java.util.Scanner;
/*
 * 배열 재귀는 잘 잘라서 반복한다!
 * */
public class BJ_2447_별찍기10_RECUR {
	static int N;
	static boolean[][] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		check = new boolean[N][N];
		
		fill_check(0, 0,  N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(check[i][j]) {
					sb.append('*');
				}else {
					sb.append(' ');
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void fill_check(int sx, int sy, int len) {
		if(len == 1) {
			check[sx][sy] = true;
			return;
		}
		
		int in_len = len/3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i != 1 || j != 1) {
					fill_check(sx+in_len*i, sy+in_len*j, in_len);
				}
			}
		}
	}

}
