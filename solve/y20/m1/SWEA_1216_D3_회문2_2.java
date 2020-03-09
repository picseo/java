package page.SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1216_D3_회문2_2 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1216.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			int len = 100;
			char[][] arr = new char[len][len];
			
			//input load
			for(int i = 0; i < len; i++) {
				String input = sc.next();
				for(int j = 0; j < len; j++) {
					arr[i][j] = input.charAt(j);
				}
			}	
				
			int Max = 1;
			//행을 기준으로 회문 찾기
			for(int j = 0; j < len; j++) {
				boolean[][] row = new boolean[len][len];
				
				//1, 2개의 회문은 미리 표시한다.
				for(int p = 0; p < len; p++) {
					row[p][p] = true;
					if(Max < 1)
						Max = 1;
					if(p!= (len-1) && arr[j][p] == arr[j][p+1]) {
						row[p][p+1] = true;
						if(Max < 2)
							Max = 2;
					}
				}
					
				for(int k = 2; k < len; k++) {
					for(int p = 0; p < (len-k); p++) {
						if(row[p+1][p+k-1] &&arr[j][p] == arr[j][p+k]) {
							if(Max < k+1)
								Max = k+1;
							row[p][p+k] = true;
						}
					}
				}
			}
			
			//열을 기준으로 회문 찾기
			for(int j = 0; j < len; j++) {
				boolean[][] col = new boolean[len][len];
					
				//1, 2개의 회문은 미리 표시한다.
				for(int p = 0; p < len; p++) {
					col[p][p] = true;
					if(Max < 1)
						Max = 1;
					if(p!=(len-1) && arr[p][j] == arr[p+1][j]) {
						col[p][p+1] = true;
						if(Max < 2)
							Max = 2;
					}
				}
					
				for(int k = 2; k < len; k++) {
					for(int p = 0; p < (len-k); p++) {
						if(col[p+1][p+k-1] &&arr[p][j] == arr[p+k][j]) {
							if(Max < k+1)
								Max = k+1;
							col[p][p+k] = true;
						}
					}
				}
			}
			
			System.out.println("#"+n+" "+Max);
		}//testcase
		
	}//main
}
