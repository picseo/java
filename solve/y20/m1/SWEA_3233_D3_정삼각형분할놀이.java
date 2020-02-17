package algo_basic.SWEA.mon1;

import java.util.Scanner;

public class SWEA_3233_D3_정삼각형분할놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int gab = a/b;
			long result = 0;
			for(long i = 0; i < gab; i++) {
				result += ((2*i)+1);
			}
			
			System.out.println("#"+t+" "+result);
		}

	}

	private static String src = "2\r\n" + 
			"2 1\r\n" + 
			"3 3";
}
