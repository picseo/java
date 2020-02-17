package algo_basic.SWEA.mon1;

import java.util.Scanner;

public class SWEA_2005_D2_파스칼의삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			System.out.println("#"+t);
			int n = sc.nextInt();
			
			int[][] save = new int[2][20];
			
			for(int i = 1; i <=n; i++) {
				for(int j = 0; j <i; j++) {
					if(j == 0 || j == i-1) {
						save[i%2][j] = 1;
					}else {
						save[i%2][j] = save[(i+1)%2][j-1] + save[(i+1)%2][j];
					}
					System.out.print(save[i%2][j] +" ");
				}
				System.out.println();
			}
		}
	}

	private static String src = "3\r\n" + 
			"4\r\n"+
			"10\r\n"+
			"11";
}
