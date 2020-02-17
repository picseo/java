package algo_basic.SWEA.mon1;

import java.util.Scanner;

public class SWEA_2805_D3_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int result = 0;
			int n = sc.nextInt();

			String[] space = new String[n];
			
			for(int i = 0; i < n ;i++) {
				space[i] = sc.next();
			}
			
			int half = n/2;
			int front = half;
			int num = 1;
			
			for(int i = 0; i < n; i++) {
				
				for(int j = 0; j < num; j++) {
					result += space[i].charAt(front + j) -'0';
				}
				
				if(i < half) {
					num += 2;
					front--;
				}else {
					num -= 2;
					front++;
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
