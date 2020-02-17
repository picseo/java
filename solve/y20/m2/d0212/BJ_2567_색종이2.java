package algo_basic.SWEA.d0212;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2567_색종이2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		//boolean[][] white = new boolean[101][101];
		int[][] white = new int[30][30];
		int result = 0;
		
		for(int i = 0; i < n ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			//둘레 체크
			for(int j =0 ; j <= 10; j++) {
				if(white[x][y+j] == 0) {
					white[x][y+j] = 1+0*3;
					result++;
				}
				
				if(white[x+10][y+j]==0) {
					white[x+10][y+j] = 1;
					result++;
				}
				
				if(white[j+x][y]==0) {
					white[j+x][y] = 1;
					result++;
				}
				
				if(white[j+x][y+10]==0) {
					white[j+x][y+10] = 1;
					result++;
				}
			}
			
			//내부 체크
			for(int j =1 ; j <= 9; j++) {
				for(int k = 1; k <= 9; k++) {
						if(white[j+x][y+k] == 1) {
							white[j+x][y+k] = 2;
							result--;
						}else if(white[j+x][y+k] == 0) {
							white[j+x][y+k] = 2;
						}
				}
			}
			/*//둘레 체크
			for(int j =0 ; j < 10; j++) {
				if(!white[x][y+j]) {
					white[x][y+j] = true;
					result++;
				}
				if(!white[x+9][y+j]) {
					white[x+9][y+j] = true;
					result++;
				}
				if(!white[j+x][y]) {
					white[j+x][y] = true;
					result++;
				}
				if(!white[j+x][y+9]) {
					white[j+x][y+9] = true;
					result++;
				}
			}
			
			//내부 체크
			for(int j =0 ; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
						white[j+x][y+k] = true;
				}
			}*/
			
			for(int[] a : white) {
				System.out.println(Arrays.toString(a));
			}
			System.out.println();
			System.out.println("result : " + result);
		}
		sc.close();
		System.out.println("last : " + result);

	}

}
