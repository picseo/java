package d0323;

import java.util.Scanner;

/*
 * ������ �Ű澲�� �����Ƿ� 
 * ������ �ٸ� �͵��� �ϳ��� �׷����� ����� �װ��� ��ǥ�� ����
 * -> ���⼭�� ������ ������ ���������  �� ������ �����ϴ� �ո� ���Ѵ�.
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
