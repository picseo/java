package swea.d0207;

import java.util.Scanner;

public class SWEA_3376_D3_파도반수열 {
	private static long[] nums = new long[200];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		
		for(int i = 0; i <= 100; i++) {
			if(i <3) {
				nums[i] = 1;
			}else if(i >= 3 && i < 5) {
				nums[i] = 2;
			}else {
				nums[i] = nums[i-1] + nums[i-5];
			}
		}
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			System.out.println("#"+t+" "+nums[n-1]);
		}
	}
	
	
	private static String src = "\r\n" + 
			"2\r\n" + 
			"6\r\n" + 
			"12";
}
