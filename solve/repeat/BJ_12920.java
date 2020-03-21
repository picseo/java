package fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 시간 초과 날것 같지만 일단 시도해본다.
 * 
 * 
 * k가 주어졌을때 이것을 2의 제곱수로 분리해서 넣으면
 * 자기들 끼리 조합을 만들어서 2^k-1가지의 합을 표현한다.
 * 
 * 7 -> 1, 2, 4로 나누어서 넣으면
 * 1, 2, (1+2), 4, (1+4), (2+4), (1+2+4)로 표현할 수 있으므로
 * 여기서 부터는 냅색 문제가 된다
 * 
 * 그리고 저장하는 배열을 1차원으로 할 수 있는데
 * 이때는 이전의 값을 바꾸지 않은 상태로 사용해야 하기때문에 뒤에서 부터
 * 값을 읽어서 사용한다.(작은 값부터 하면 뒤의 값을 계산할때 현재 값이 들어가서 계산이 이상하게 된다.)
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
			//갯수를 2의 제곱수의 합으로 분리
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
