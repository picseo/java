package swea.d0214;

import java.util.Scanner;
//입력을 string으로 받아 하나하나 확인했다.
public class SWEA_7728_D3_다양성측정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			boolean [] div = new boolean[10];
			
			String input = sc.next();
			for(int i = 0; i < input.length(); i++) {
				int now = input.charAt(i)-'0';
				if(!div[now]) {
					div[now] = true;
				}
			}
			
			int res = 0;
			for(int i = 0; i < 10; i++) {
				if(div[i])
					res++;
			}
			System.out.println("#"+t+" "+res);
		}

	}
	private static String src = "2\r\n" + 
			"1512\r\n" + 
			"20170310";
}
