package swea.d0207;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_3260_D3_두수의덧셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			String a = sc.next();
			String b = sc.next();
			int alen = a.length();
			int blen = b.length();
			
			int[] arr = new int[alen];
			int[] brr = new int[blen];
			
			for(int i = 0; i < alen; i++) {
				arr[i] = a.charAt(alen-1-i) - '0';
			}
			for(int i = 0; i < blen; i++) {
				brr[i] = b.charAt(blen-1-i)-'0';
			}
			
			
			int pre =0;
			if(alen > blen) {
				for(int i = 0; i < alen; i++) {
					int tmp = arr[i] + pre;
					
					if(i < blen) {
						tmp += brr[i];
					}
					
					pre = 0;
					if(tmp >= 10) {
						pre = tmp/10;
					}					
					st.push(tmp%10);

				}
				while(pre > 0) {
					st.push(pre%10);
					pre /= 10;
				}
			}else {
				for(int i = 0; i < blen; i++) {
					int tmp = brr[i] + pre;
					
					if(i < alen) {
						tmp += arr[i];
					}
					
					pre = 0;
					if(tmp >= 10) {
						pre = tmp/10;
					}		
					st.push(tmp%10);
				}
				while(pre > 0) {
					st.push(pre%10);
					pre /= 10;
				}
			}
			
			System.out.print("#"+t+" ");
			
			while(!st.isEmpty()) {
				System.out.print(st.pop());
			}
		}
	}

	private static String src = "2\r\n" + 
			"999 99\r\n" + 
			"100000000000000000000000002 9";
}
