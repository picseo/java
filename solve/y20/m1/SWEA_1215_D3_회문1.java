package page.SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1215_D3_회문1 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1215.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			char[][] arr = new char[8][8];
			
			//input load
			for(int i = 0; i < 8; i++) {
				String input = sc.next();
				for(int j = 0; j < 8; j++) {
					arr[i][j] = input.charAt(j);
				}
			}	
				
			int result = 0;
			//행을 기준으로 회문 찾기
			for(int j = 0; j < 8; j++) {
				boolean[][] pal = new boolean[8][8];
					
				//1, 2개의 회문은 미리 표시한다.
				for(int p = 0; p < 8; p++) {
					pal[p][p] = true;
					if(p!=7 && arr[j][p] == arr[j][p+1]) {
						pal[p][p+1] = true;
					}
				}
					
				for(int k = 2; k < n; k++) {
					for(int p = 0; p < (8-k); p++) {
						if(pal[p+1][p+k-1] &&arr[j][p] == arr[j][p+k]) {
							if(k == n-1)
								result++;
							pal[p][p+k] = true;
						}
					}
				}
			}
			
			//열을 기준으로 회문 찾기
			for(int j = 0; j < 8; j++) {
				boolean[][] pal = new boolean[8][8];
					
				//1, 2개의 회문은 미리 표시한다.
				for(int p = 0; p < 8; p++) {
					pal[p][p] = true;
					if(p!=7 && arr[p][j] == arr[p+1][j]) {
						pal[p][p+1] = true;
					}
				}
					
				for(int k = 2; k < n; k++) {
					for(int p = 0; p < (8-k); p++) {
						if(pal[p+1][p+k-1] &&arr[p][j] == arr[p+k][j]) {
							if(k == n-1)
								result++;
							pal[p][p+k] = true;
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
		}//testcase
		
	}//main
}
