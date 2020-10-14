package d0902;

import java.util.*;

public class BJ_4811_¾Ë¾à {
	static long[][] memo;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int N = sc.nextInt();
			if(N == 0) {
				break;
			}
			
			memo = new long[N+1][N+1];
			
			for(long[] a : memo) {
				Arrays.fill(a,  -1);
			}
			
			long result = find(N, 0);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
		return;
	}
	
	private static long find(int w, int h) {
		if(memo[w][h] != -1) {
			return memo[w][h];
		}
		
		if(w+h == 0) {
			return 1;
		}
		
		long result = 0;
		if(w > 0) {
			result += find(w-1, h+1);
		}
		if(h > 0) {
			result += find(w, h-1);
		}
		
		memo[w][h] = result;
		return memo[w][h];
	}
	
	
}
