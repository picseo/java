package algo_basic.SWEA.d0212;

import java.util.Scanner;

public class BJ_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean[][] white = new boolean[101][101];
		int result = 0;
		for(int i = 0; i < n ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j =0 ; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					if(!white[j+x][y+k]) {
						white[j+x][y+k] = true;
						result++;
					}
				}
			}
			
		}
		
		System.out.println(result);

	}

}
