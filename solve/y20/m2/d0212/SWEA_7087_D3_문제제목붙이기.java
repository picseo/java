package algo_basic.SWEA.d0212;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_7087_D3_문제제목붙이기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();
		boolean[] alph = new boolean[26];
		
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			Arrays.fill(alph, false);
			
			for(int i = 0; i < n ; i++) {
				String input = sc.next();
				alph[input.charAt(0)-'A'] = true;
			}
			
			System.out.print("#"+t+" ");
			int res = -1;
			for(int i = 0; i < 26; i++) {
				if(!alph[i]) {
					res = i;
					break;
				}
			}
			if(res == -1)
				System.out.println(26);
			else {
				System.out.println(res);
			}
		}
	}

	private static String src = "3\r\n" + 
			"5\r\n" + 
			"Air\r\n" + 
			"Dad\r\n" + 
			"Ear\r\n" + 
			"Blue\r\n" + 
			"Ace\r\n" + 
			"3\r\n" + 
			"Snow_White\r\n" + 
			"A_Problem\r\n" + 
			"Another_Problem\r\n" + 
			"2\r\n" + 
			"Good_Problem\r\n" + 
			"Better_Problem";
}
