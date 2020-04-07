package d0324;

import java.util.Arrays;
import java.util.Scanner;
//StringBuilder�� ���� �ʾƼ� �ð� �ʰ��� ����. �׳� �ƿ�ǲ�� STringBuilder�� �̿��ϱ�� ����
//�׸��� �ѹ� �Դ� ������ �� Ȯ���ϱ� ���ؼ� 1, 0���� ó�� ��� ���� -1�� �ʱ�ȭ�ϴ°�
//�ߺ������ �ٿ��ٰ� ����.
public class BJ_10942_bottomup {
	static int N, M;
	static int[] input;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		N = sc.nextInt();
		input = new int[N+1];
		dp = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			input[i] = sc.nextInt();
			dp[i][i] = 1;
		}
		
		for(int i = 1; i < N; i++) {//����
			for(int j = 1; j<= N-i; j++) {//������
				if(i == 1) {
					if(input[j] == input[j+1]) {
						dp[j][j+i] = 1;
					}else {
						dp[j][j+1] = 0;
					}
				}else {
					if(input[j] == input[j+i] && dp[j+1][j+i-1] == 1) {
						dp[j][j+i] = 1;
					}else {
						dp[j][j+i] = 0;
					}
				}
			}
		}
		
		M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			sb.append(dp[s][e]).append("\n");
		}
		System.out.println(sb);
	}

	private static String src = "7\r\n" + 
			"1 2 1 3 1 2 1\r\n" + 
			"4\r\n" + 
			"1 3\r\n" + 
			"2 5\r\n" + 
			"3 3\r\n" + 
			"5 7";
}
