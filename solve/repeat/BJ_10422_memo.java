package repeat;

import java.util.Scanner;
/*
 * 이 풀이는 L길이의 괄호 문자열이 있을 때
 * 맨 뒤가 (이거나 )인 경우의 수를
 * 모두 더하는 경우를 나타낸다. 
 * 
 * */
public class BJ_10422_memo {
	static int[][] dp = new int[5001][5001];
	static int mod = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		dp[0][0] = 1;
		for(int i = 1; i <= 5000; i++) {
			for(int j = 0; j <= i; j++) {
				if(j+1 <= i)
					dp[i][j] += dp[i-1][j+1];
				if(j-1 >= 0)
					dp[i][j] += dp[i-1][j-1];
				dp[i][j] %= mod; 
			}
		}
		for(int t = 0; t < T; t++) {
			int n = sc.nextInt();
			
			sb.append(dp[n][0]).append("\n");
		}
		System.out.println(sb);
	}
}
