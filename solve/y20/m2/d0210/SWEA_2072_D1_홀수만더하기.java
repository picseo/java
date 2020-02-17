package swea.d0210;

import java.util.Scanner;

public class SWEA_2072_D1_홀수만더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			int result = 0;
			for(int i =0; i < 10; i++) {
				int tmp = sc.nextInt();
				if(tmp % 2 == 1) {
					result += tmp;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
	
	private static String src = "3\r\n" + 
			"3 17 1 39 8 41 2 32 99 2\r\n" + 
			"22 8 5 123 7 2 63 7 3 46\r\n" + 
			"6 63 2 3 58 76 21 33 8 1 ";
}
