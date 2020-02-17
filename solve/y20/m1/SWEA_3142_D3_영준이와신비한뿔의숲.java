package algo_basic.SWEA.mon1;

import java.util.Scanner;

public class SWEA_3142_D3_영준이와신비한뿔의숲 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t= 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int u_num = 0;
			int t_num = 0;
			
			for(int th = 0; th <= m; th++) {
				int result = th*2+(m-th);
				if(result == n) {
					u_num = m-th;
					t_num = th;
					break;
				}				
			}
			
			System.out.println("#"+t+" "+u_num+" "+t_num);
		}

	}
	
	private static String src = "\r\n" + 
			"2\r\n" + 
			"5 3\r\n" + 
			"7 5";
}
