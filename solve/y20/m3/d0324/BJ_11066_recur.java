package d0324;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11066_recur {
	static int K, N;
	static int[][] dp = new int[502][502];//dp[i][j] : i~j���� ��ģ ��
	static int[] sum = new int[502];//sum[i] : i��° ������ ��� ���� ��
	
	public static int find(int s, int e) {
		if(s == e) {
			return 0;
		}
		if(dp[s][e] != -1) { //0�� ���� ���� �� �����Ƿ� -1�� �ʱ�ȭ �ϴ� ���� ����.
			return dp[s][e];
		}
		
		dp[s][e] = Integer.MAX_VALUE;
		for(int m = s; m < e; m++) {
			dp[s][e] = Math.min(dp[s][e], find(s, m)+find(m+1, e)+sum[e]-sum[s-1]);
		}
		return dp[s][e];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			K = sc.nextInt();
			for(int i = 1; i <= K; i++) {
				int tmp = sc.nextInt();
				sum[i] = sum[i-1] + tmp; 				
			}
			
			for(int i = 0; i <= K; i++) {
				Arrays.fill(dp[i],  -1);
			}
			
			System.out.println(find(1, K));
		}
	}

}
