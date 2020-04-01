package repeat;

import java.util.Arrays;
import java.util.Scanner;
/*
 * ���Ǹ� ���� �ߴ�.
 * �ùٸ� ��ȣ ���� n�� ���� �� �̰���
 * '('�ùٸ� ��ȣ(����:l-2)')'�ùٸ���ȣ(����:n-l)
 * �� �� �� ���� �� �̿��ؼ� 
 * Ǫ�� ����̴�.
 * 
 * 
 * �̰� �ٸ� �̾߱� �ε� ����ϴ� ����� �Ȱ��Ƶ� int �� �����ϸ� �ð��ʰ� �� ���µ�
 * long���� �ϸ� �ð� �ʰ��� ���� �ʴ´�.
 * ���ϱ�?
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
//		System.out.println("���� �ð� : " + (end - start)/1000.0+"��");
//		
//		long starti = System.currentTimeMillis(); 
//		findi(500);
//		long endi = System.currentTimeMillis();
//		System.out.println("���� �ð� i: " + (endi - starti)/1000.0+"��");
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
