package algo_basic.SWEA.mon1;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_8931_D3_제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int result = 0;
			int k = sc.nextInt();
			Stack<Integer> st = new Stack<>();
			
			for(int i= 0; i < k; i++) {
				int tmp = sc.nextInt();
				if(tmp == 0) {
					if(!st.isEmpty()) {
						st.pop();
					}
				}else {
					st.push(tmp);
				}
			}
			
			while(!st.isEmpty()) {
				result += st.peek();
				st.pop();
			}
			System.out.println("#"+t+" "+result);
		}

	}

	private static String src = "\r\n" + 
			"2\r\n" + 
			"6\r\n" + 
			"10000\r\n" + 
			"10000\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"100000\r\n" + 
			"0\r\n" + 
			"10\r\n" + 
			"1\r\n" + 
			"3\r\n" + 
			"5\r\n" + 
			"4\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"7\r\n" + 
			"0\r\n" + 
			"0\r\n" + 
			"6";
}
