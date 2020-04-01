package d0323;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 순서는 신경쓰지 않으므로 
 * 순서가 다른 것들을 하나의 그룹으로 만들고 그것의 대표를 세움
 * -> 여기서는 임의의 순서를 만든다음에  그 순서로 성립하는 합만 구한다.
 * 
 * 갯수를 세어야 하므로 dp배열을 일단 -1로 초기화해주었다.
 * 그 뒤 dp가 -1일때는 일단 가능한 값으로 넣어주었고
 * 만약 현재 값을 가지고 있다면 새로 구한 값이 더 작은 경우만 바꾸었다.
 * 
 * 여기서 중요한 것은 새로구하는 값이 이미 구해지지 않은 값일때는 구하면 안되는데
 * 처음에는 이 값도 그냥 구해서 틀렸었다.
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
