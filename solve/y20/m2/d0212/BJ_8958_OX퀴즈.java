package algo_basic.SWEA.d0212;

import java.util.Scanner;

public class BJ_8958_OX퀴즈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 0 ; t < T; t++) {
			String input = sc.next();
			
			int result = 0;
			int onum = 1;
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == 'O') {
					result += (onum++);
				}else {
					onum = 1;
				}
			}
			System.out.println(result);
		}

	}
	
	private static String src = "5\r\n" + 
			"OOXXOXXOOO\r\n" + 
			"OOXXOOXXOO\r\n" + 
			"OXOXOXOXOXOXOX\r\n" + 
			"OOOOOOOOOO\r\n" + 
			"OOOOXOOOOXOOOOX";
}
