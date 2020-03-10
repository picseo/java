package JA;

import java.util.Scanner;

public class JA_1707_달팽이사각형 {
	private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		
		int x = 0;
		int y = -1;

		int dir = 0;
		int now = 1;
		for(int i = n; i>=1; i--) {
			if(i == n) {
				for(int j = 0; j < i; j++) {
					x += dirs[dir][0];
					y += dirs[dir][1];
					arr[x][y] = now++;
				}
				dir = (dir+1)%4;
			}else {
				for(int cnt = 2; cnt > 0; cnt--) {
					for(int j = 0; j < i; j++) {
						x += dirs[dir][0];
						y += dirs[dir][1];
						arr[x][y] = now++;
					}					
					dir = (dir+1)%4;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

}
