package algo_basic.SWEA.d0212;

import java.util.Arrays;
import java.util.Scanner;
///이건 너무 어렵다. 1로 다 채운다음에 1주변의 0의 갯수만큼 채운다.
public class BJ_2567_색종이2_2 {
	private static int dirs[][] =  {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean[][] white = new boolean[101][101];

		for(int i = 0; i < n ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
	
			for(int j =0 ; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
						white[j+x][y+k] = true;
				}
			}
		}	
			
		int cnt = 0;
		for(int i = 0 ; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(white[i][j]) {
					for(int d = 0 ; d < 4; d++) {
						int x = i + dirs[d][0];
						int y = j + dirs[d][1];
						if(x >= 0 && x <= 100 && y >=0 && y<=100) {
							if(!white[x][y]) {
								cnt++;
							}
						}
					}
				}
			}
		}

		sc.close();
		System.out.println(cnt);

	}

}
