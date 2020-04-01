package d0323;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_11048_2 {
	static int N, M;
	static int[][] candy = new int[1001][1001];
	static int max = Integer.MIN_VALUE;
	static int[][] dirs = {{0, 1}, {1, 0}, {1, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i = 0; i < N ; i ++) {
			for(int j = 0; j < M; j++) {
				candy[i][j] = sc.nextInt();
			}
		}

		int[][] row  = new int[N][M];
		row[0][0] = candy[0][0];
		for(int i = 1; i < M; i++) {
			row[0][i] = candy[0][i] + row[0][i-1];
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(j == 0) {
					row[i][j] = row[i-1][j] + candy[i][j];
				}else {
					//어차피 아래, 오가 위왼보다 항상 크기때문에
					row[i][j] = Math.max(row[i-1][j], row[i][j-1]) + candy[i][j];
				}
			}
		}
		
		System.out.println(row[N-1][M-1]);
		sc.close();
	}

}
