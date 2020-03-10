package JA;

import java.util.Scanner;

public class JA_1438_»öÁ¾ÀÌ2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int n = sc.nextInt();
		boolean[][] minmax = new boolean[101][101];
				
		for(int i = 0; i < n ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					minmax[j+x][k+y] = true;
				}
				
			}			
		}
		
		int result = 0;
		for(int i = 0; i <=100; i++) {
			for(int j = 0; j<=100; j++) {
				if(minmax[i][j])
					result++;
			}
		}
		
		System.out.println(result);
	}
	
	/*
	 * private static String src = "3 \r\n" + "3 7 \r\n" + "15 7 \r\n" + "5 2";
	 */
	private static String src = "4\r\n" + 
			"37 40\r\n" + 
			"30 47\r\n" + 
			"44 47\r\n" + 
			"37 54";
}
