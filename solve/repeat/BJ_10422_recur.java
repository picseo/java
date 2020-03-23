package repeat;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 강의를 보고 했다.
 * 올바른 괄호 길이 n이 있을 때 이것은
 * '('올바른 괄호(길이:l-2)')'올바른괄호(길이:n-l)
 * 로 볼 수 있음 을 이용해서 
 * 푸는 방식이다.
 * 
 * 
 * 이건 다른 이야기 인데 계산하는 방법이 똑같아도 int 로 진행하면 시간초과 가 나는데
 * long으로 하면 시간 초과가 나지 않는다.
 * 왜일까?
 * */
public class BJ_10422_recur {
	static long[] dp = new long[5001];
	static long mod = 1000000007;
	
//	static int[] dpi = new int[5001];
//	static int modi = 1000000007;
//	
//	static int findi(int n) {
//		if(n == 0) {
//			return 1;
//		}else if(dpi[n] >= 0) {
//			return dpi[n];
//		}else {
//			dpi[n] = 0;
//			for(int l = 2; l <= n; l +=2 ) {
//				dpi[n] += (findi(n-l)*findi(l-2));
//				dpi[n] %= modi;
//			}
//			return dpi[n];
//		}
//	}
	
	static long find(int n) {
		if(n == 0) {
			return 1;
		}else if(dp[n] >= 0) {
			return dp[n];
		}else {
			dp[n] = 0;
			for(int l = 2; l <= n; l +=2 ) {
				dp[n] += (find(n-l)*find(l-2));
				dp[n] %= mod;
			}
			return dp[n];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		Arrays.fill(dp,  -1);
//		Arrays.fill(dpi,  -1);
//		long start = System.currentTimeMillis(); 
//		find(500);
//		long end = System.currentTimeMillis();
//		System.out.println("실행 시간 : " + (end - start)/1000.0+"초");
//		
//		long starti = System.currentTimeMillis(); 
//		findi(500);
//		long endi = System.currentTimeMillis();
//		System.out.println("실행 시간 i: " + (endi - starti)/1000.0+"초");
		for(int t = 0; t < T; t++) {
			int n = sc.nextInt();
			if(n%2 != 0) {
				sb.append("0\n");
			}else {
				if(dp[n] == -1) {
					find(n);
				}
				sb.append(dp[n]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
