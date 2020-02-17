package algo_basic.SWEA.mon1;

import java.util.Scanner;

public class SWEA_2805_D3_농작물수확하기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int result = 0;
			int n = sc.nextInt();
			int st = n/2 + 1;
			int end = n/2 - 1;
			String[] space = new String[n];
			
			for(int i = 0; i < n ;i++) {
				space[i] = sc.next();
			}
			
			for(int i = 0; i < n; i++) {
				if(i > n/2) {
					st += 1;
					end -= 1;
				}else {
					st -= 1;
					end += 1;
				}

				for(int j = 0; j < n; j++) {
					if(st <= j && j<=end) {
						result += (space[i].charAt(j) -'0');
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static String src = "1\r\n" + 
			"5\r\n" + 
			"14054\r\n" + 
			"44250\r\n" + 
			"02032\r\n" + 
			"51204\r\n" + 
			"52212";
}
