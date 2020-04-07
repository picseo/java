package d0324;

import java.util.Arrays;
import java.util.Scanner;
//StringBuilder를 쓰지 않아서 시간 초과가 났다. 그냥 아웃풋은 STringBuilder를 이용하기로 하자
//그리고 한번 왔다 갔는지 를 확인하기 위해서 1, 0말고도 처음 모든 값을 -1로 초기화하는게
//중복계산을 줄여줄것 같다.
public class BJ_10942_topdown {
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
			Arrays.fill(dp[i], -1);
		}
		
		M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			sb.append(find(s, e)).append("\n");
		}
		System.out.println(sb);
	}

	private static int find(int s, int e) {
		if(dp[s][e] != -1) {
			return dp[s][e];
		}
		
		if(s == e) {
			dp[s][e] = 1;
			return 1;
		}
		
		if(s+1 == e) {
			if(input[s] == input[e]) {
				dp[s][e] = 1;
			}else {
				dp[s][e] = 0;
			}
			return dp[s][e];
		}
		
		if(input[s] == input[e]) {
			dp[s][e] = find(s+1, e-1);
		}else {
			dp[s][e] = 0;
		}
		return dp[s][e];
	}

	private static String src = "7\r\n" + 
			"1 2 1 3 1 2 1\r\n" + 
			"4\r\n" + 
			"1 3\r\n" + 
			"2 5\r\n" + 
			"3 3\r\n" + 
			"5 7";
}
