package swea.d0210;

import java.util.Scanner;

public class SWEA_6730_D3_장애물경주난이도 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			int up = 0;
			int down = 0;
			int n = sc.nextInt();
			int pre = sc.nextInt();
			for(int i = 1; i < n ; i++) {
				int now = sc.nextInt();
				if(now > pre) {
					if(up < (now-pre))
						up = now-pre;
				}else {
					if(down < (pre-now))
						down = (pre-now);
				}
				pre = now;
			}
			
			System.out.println("#"+t+" "+up+" "+down);
		}
	}

	private static String src = "\r\n" + 
			"5\r\n" + 
			"5\r\n" + 
			"10 70 30 50 90\r\n" + 
			"2\r\n" + 
			"30 100\r\n" + 
			"2\r\n" + 
			"100 20\r\n" + 
			"3\r\n" + 
			"40 40 40\r\n" + 
			"7\r\n" + 
			"12 345 678 901 23 45 6";
}
