package fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * �ð� �ʰ� ���� ������ �ϴ� �õ��غ���.
 * 
 * 
 * k�� �־������� �̰��� 2�� �������� �и��ؼ� ������
 * �ڱ�� ���� ������ ���� 2^k-1������ ���� ǥ���Ѵ�.
 * 
 * 7 -> 1, 2, 4�� ����� ������
 * 1, 2, (1+2), 4, (1+4), (2+4), (1+2+4)�� ǥ���� �� �����Ƿ�
 * ���⼭ ���ʹ� ���� ������ �ȴ�
 * 
 * �׸��� �����ϴ� �迭�� 1�������� �� �� �ִµ�
 * �̶��� ������ ���� �ٲ��� ���� ���·� ����ؾ� �ϱ⶧���� �ڿ��� ����
 * ���� �о ����Ѵ�.(���� ������ �ϸ� ���� ���� ����Ҷ� ���� ���� ���� ����� �̻��ϰ� �ȴ�.)
 * */
public class BJ_12920 {
	static int MAX = 10001;
	static int N, M;
	static int[] v, c, k, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		v = new int[MAX];
		c = new int[MAX];
		k = new int[MAX];
		for(int i = 1; i <= N; i++) {
			v[i] = sc.nextInt();
			c[i] = sc.nextInt();
			k[i] = sc.nextInt();
		}
		
		List<int[]> list = new ArrayList();
		for(int i = 1; i <= N; i++) {
			//������ 2�� �������� ������ �и�
			for(int j = k[i]; j>0; j >>=1) {
				int num = j - (j>>1);
				list.add(new int[] {v[i]*num, c[i]*num});
			}
		}
		
		dp = new int[MAX];
		for(int i =0 ; i < list.size(); i++) {
			int v_num = list.get(i)[0];
			int c_num = list.get(i)[1];
			for(int j = M; j >= v_num; j--) {
				dp[j] = Math.max(dp[j],  dp[j-v_num]+c_num);
			}
		}
//		
//		for(int i = 0; i <= M; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		System.out.println(dp[M]);
	}

	private static String src = "3 9\r\n" + 
			"8 5 1\r\n" + 
			"1 2 2\r\n" + 
			"9 4 1";
}
