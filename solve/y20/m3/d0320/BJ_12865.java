package d0320;

import java.util.Arrays;
import java.util.Scanner;
/*
 * dp�����ε� if������ �ɷ����� ��쿡�� ���� �Ѱ��־�� �ϴ� �� ���ؼ� Ʋ�Ⱦ���.
 * */
public class BJ_12865 {
	static int N, K;
	static int[] w, v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		N = sc.nextInt();
		K = sc.nextInt();
		w = new int[N+1];
		v = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		int[][] dp = new int[K+1][N+1];
		for(int i = 1; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = dp[i][j-1];//�̺κ��� �߰��ؾ� �ߴ�(�ֳ��ϸ� i>=w[j]������ �������� ������ ���� ���� �־�����ϹǷ�
				if(i >= w[j]) {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-w[j]][j-1] + v[j]);
				}
			}
		}
		
		System.out.println(dp[K][N]);
	}


	private static String src = "4 7\r\n" + 
			"6 13\r\n" + 
			"4 8\r\n" + 
			"3 6\r\n" + 
			"5 12";
}
