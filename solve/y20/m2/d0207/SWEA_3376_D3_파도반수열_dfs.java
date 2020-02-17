package swea.d0207;

import java.util.Scanner;

public class SWEA_3376_D3_파도반수열_dfs {
	private static long[] nums = new long[200];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			recur(n);
			System.out.println("#"+t+" "+nums[n-1]);
		}
	}
	
	private static long recur(int n) {
		if(n < 3) {
			nums[n] = 1;
			return 1;
		}else if(n>=3 && n<5) {
			nums[n] = 2;
			return 2;
		}else {
			if(nums[n] == 0) {
				nums[n] = recur(n-1)+recur(n-5);
			}
			return nums[n];
		}
	}
	
	private static String src = "\r\n" + 
			"2\r\n" + 
			"6\r\n" + 
			"12";
}
