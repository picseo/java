package algo_basic.SWEA.mon1;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_2001_D2_파리퇴치 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\2001.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			System.out.print("#"+t+" ");

			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] pr = new int[n][n];
			
			for(int i = 0; i < n; i ++) {
				for(int j = 0; j <n ;j++) {
					pr[i][j] = sc.nextInt();
				}
			}
			
			int Max = Integer.MIN_VALUE;
			for(int i = 0; i <= n-m; i++) {
				for(int j = 0; j <= n-m; j++) {
					int tmp = 0;
					
					for(int ii= 0; ii < m ; ii++) {
						for(int jj = 0; jj < m; jj++) {
							tmp += pr[i+ii][j+jj];
						}
					}
					
					Max = Integer.max(Max,  tmp);
				}
			}
			
			System.out.println(Max);
		}
	}

}
