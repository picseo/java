package d0323;

import java.util.Scanner;

/*
 * 순서는 신경쓰지 않으므로 
 * 순서가 다른 것들을 하나의 그룹으로 만들고 그것의 대표를 세움
 * -> 여기서는 임의의 순서를 만든다음에  그 순서로 성립하는 합만 구한다.
 * */
public class BJ_2293 {
	static int N, K;
	static int[] coins = new int[101];
	static int[]dp = new int[10001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		
		dp[0] = 1;
		for(int i = 0; i < N ;i++) {
			for(int k = coins[i]; k <= K; k++) {
				dp[k] += dp[k - coins[i]];
			}
		}

		System.out.println(dp[K]);
	}

}
