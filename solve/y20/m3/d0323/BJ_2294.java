package d0323;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ������ �Ű澲�� �����Ƿ� 
 * ������ �ٸ� �͵��� �ϳ��� �׷����� ����� �װ��� ��ǥ�� ����
 * -> ���⼭�� ������ ������ ���������  �� ������ �����ϴ� �ո� ���Ѵ�.
 * 
 * ������ ����� �ϹǷ� dp�迭�� �ϴ� -1�� �ʱ�ȭ���־���.
 * �� �� dp�� -1�϶��� �ϴ� ������ ������ �־��־���
 * ���� ���� ���� ������ �ִٸ� ���� ���� ���� �� ���� ��츸 �ٲپ���.
 * 
 * ���⼭ �߿��� ���� ���α��ϴ� ���� �̹� �������� ���� ���϶��� ���ϸ� �ȵǴµ�
 * ó������ �� ���� �׳� ���ؼ� Ʋ�Ⱦ���.
 * */
public class BJ_2294 {
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
		
		Arrays.fill(dp,  -1);
		dp[0] = 0;
		for(int i = 0; i < N ;i++) {
			for(int k = coins[i]; k <= K; k++) {
				if(dp[k] == -1) {
					if(dp[k-coins[i]] != -1)
						dp[k] = dp[k-coins[i]] + 1;
				}else {
					if(dp[k-coins[i]] != -1)
						dp[k] = Math.min(dp[k-coins[i]] + 1, dp[k]);
				}
			}
		}

		System.out.println(dp[K]);
	}

}
