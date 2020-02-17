package swea.d0207;

import java.util.Scanner;

public class SWEA_3304_D3_최장공통부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			String str1 = sc.next();
			String str2 = sc.next();
			int len1 = str1.length();
			int len2 = str2.length();
			int res = 0;
			
			if(len1 >= len2) {
				int idx2 = 0;
				for(int i =0 ; i < len1; i++) {
					if(i >= len2 && i>=len1)
						break;
					if(str1.charAt(i) == str2.charAt(idx2)) {
						idx2++;
						res++;
					}else {
						i--;
						idx2++;
					}
				}
			}else {
				int idx1 = 0;
				for(int i =0 ; i < len2; i++) {
					if(i >= len1)
						break;
					if(str2.charAt(i) == str1.charAt(idx1)) {
						idx1++;
						res++;
					}
				}
			}
			
			System.out.println("#"+t+" "+res);
		}
		
	}

	private static String src = "1\r\n" + 
			"acaykp capcak";
}
