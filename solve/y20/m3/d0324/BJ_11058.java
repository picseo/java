package d0324;

import java.util.Scanner;
//long 타입!!!!!
//결국 N이 100이라서 모든 경우의 수를 다 해보는 문제였다.
//단, 앞의 값을 계속사용해야 하므로 dp에 저장해서 그때그때 불러 사용해서 풀었다.
public class BJ_11058 {
	static int N;
	static long[] dp = new long[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			dp[i] = dp[i-1]+1;
			
			for(int j = 1; j <= i-3; j++) {
				long tmp = dp[i-(j+2)]*(j+1);//j는 뒤에 반복되는 횟수를 의미
				dp[i] = Math.max(tmp,  dp[i]);
			}
			
		}
		
		System.out.println(dp[N]);
	}

}
