package d0324;

import java.util.Scanner;
//long Ÿ��!!!!!
//�ᱹ N�� 100�̶� ��� ����� ���� �� �غ��� ��������.
//��, ���� ���� ��ӻ���ؾ� �ϹǷ� dp�� �����ؼ� �׶��׶� �ҷ� ����ؼ� Ǯ����.
public class BJ_11058 {
	static int N;
	static long[] dp = new long[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			dp[i] = dp[i-1]+1;
			
			for(int j = 1; j <= i-3; j++) {
				long tmp = dp[i-(j+2)]*(j+1);//j�� �ڿ� �ݺ��Ǵ� Ƚ���� �ǹ�
				dp[i] = Math.max(tmp,  dp[i]);
			}
			
		}
		
		System.out.println(dp[N]);
	}

}
