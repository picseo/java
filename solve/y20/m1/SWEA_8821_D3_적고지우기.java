package page.SWEA;

import java.util.Scanner;

public class SWEA_8821_D3_적고지우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			String str = sc.next();
			int result = 0;
			boolean[] check = new boolean[10];
			
			for(int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i)-'0';
				if(!check[idx]) {
					check[idx] = true;
				}else {
					check[idx] = false;
				}
			}		
			
			for(int i = 0; i < 10; i++) {
				if(check[i]) {
					result++;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}

	private static String src = "\r\n" + 
			"3\r\n" + 
			"\r\n" + 
			"121\r\n" + 
			"\r\n" + 
			"0123456789\r\n" + 
			"\r\n" + 
			"555555";
}
