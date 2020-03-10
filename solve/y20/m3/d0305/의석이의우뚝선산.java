package d0305;

import java.util.Scanner;
import java.util.StringTokenizer;

public class 의석이의우뚝선산 {
	static long[] heights = null;
	static int n = 0;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t= 1;t <= T; t++) {
			sb.append("#").append(t).append(" ");
			n = sc.nextInt();
			heights = new long[n];
			for(int i = 0; i < n ; i++) {
				heights[i] = sc.nextLong();
			}
			
			long[] left = new long[n];
			long[] right = new long[n];
			for(int i = 1; i < n-1; i++) {
				if(heights[i-1] < heights[i]) {
					left[i] = left[i-1] + 1;
				}else {
					left[i] = 0;
				}
			}
			
			for(int i = n-2; i > 0; i--) {
				if(heights[i+1] < heights[i]) {
					right[i] = right[i+1] + 1;
				}else {
					right[i] = 0;
				}
			}
			
			long result = 0;
			for(int i = 0; i < n; i++) {
				result += (left[i] * right[i]);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static String src = "3\r\n" + 
			"3\r\n" + 
			"1 3 2\r\n" + 
			"3\r\n" + 
			"3 2 1\r\n" + 
			"9\r\n" + 
			"1 4 6 5 3 7 9 2 8";
}
