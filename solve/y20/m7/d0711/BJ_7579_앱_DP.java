package algo;

import java.util.Scanner;

/*  
 	���� ������ ����� ���̴µ� ������ ���� �ٸ���
 	
 	i��° �۱��� �� j�ڽ�Ʈ�� ���� �� �ִ� �ִ��� byte = dp[i][j]
  */
public class BJ_7579_��_DP {
	static int[] mbyte = new int[101];
	static int[] c = new int[101];
	
	static int[][] memo = new int[101][10001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			mbyte[i] = sc.nextInt();
		}
		for(int i = 1; i <= N; i++) {
			c[i] = sc.nextInt();
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 10001; j++) {
				if(j-c[i] >= 0) {
					memo[i][j] = Math.max(memo[i][j], memo[i-1][j-c[i]] + mbyte[i]);
				}
				memo[i][j] = Math.max(memo[i][j], memo[i-1][j]);
				
				if(M <= memo[i][j] && result > j) {
					result = j;
				}
			}
		}
		
		System.out.println(result);
		
	}

}
