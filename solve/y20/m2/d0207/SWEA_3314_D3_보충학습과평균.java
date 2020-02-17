package swea.d0207;

import java.util.Scanner;

public class SWEA_3314_D3_보충학습과평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int total = 0;
			for(int i = 0; i < 5; i++) {
				int tmp = sc.nextInt();
				if(tmp < 40)
					tmp = 40;
				total += tmp;
			}
			
			total /= 5;
			System.out.println("#"+t+" "+total);
		}
	}
	
	private static String src ="1\r\n" + 
			"10 65 100 30 95";
}
