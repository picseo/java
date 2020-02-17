package swea.d0210;

import java.util.Scanner;

public class SWEA_6900_D3_주혁이의복권당첨 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T= sc.nextInt();
		for(int t= 1; t<= T; t++) {
			int result = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			String[] bnums = new String[n];
			int[] mony = new int[n];
			
			for(int i = 0; i < n ; i++) {
				bnums[i] = sc.next();
				mony[i] = sc.nextInt();
			}
			
			for(int i = 0; i < m ; i++) {
				String input = sc.next();				
				
				for(int j = 0; j < n; j++) {
					boolean check = true;
					for(int k = 0; k < input.length(); k++) {
						char bnum = bnums[j].charAt(k);
						if(bnum != '*' && input.charAt(k) != bnum) {
							check = false;
							break;
						}
					}
					if(check) {
						result += mony[j];
						break;
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
		}

	}
	
	private static String src = "\r\n" + 
			"1\r\n" + 
			"4 4\r\n" + 
			"*******1 1\r\n" + 
			"******12 10\r\n" + 
			"66*66**3 1000\r\n" + 
			"87654320 1000000\r\n" + 
			"87654320\r\n" + 
			"85288251\r\n" + 
			"48888812\r\n" + 
			"12345678";
}
