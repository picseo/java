package swea.D3;

import java.util.Scanner;

public class SWEA_1946_D2_간단한압축풀기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			System.out.println("#"+t);
			int n = sc.nextInt();
			
			int cnt = 0;
			
			for(int i =0 ; i < n; i++) {
				char input = sc.next().charAt(0);
				int num = sc.nextInt();
				
				for(int j = 0; j < num; j++) {
					System.out.print(input);
					cnt++;
					if(cnt %10 == 0) {
						System.out.println();
						cnt %= 10;
					}
				}
			}
			System.out.println();
		}

	}

	private static String src = "1\r\n" + 
			"3\r\n" + 
			"A 10\r\n" + 
			"B 7\r\n" + 
			"C 5 ";
}
