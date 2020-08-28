package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 	ㅎㅎ 알고를 꾸준히 풀어야겠다고 생각했다. 또 못풀게되다니
 	
 	맨 처음 접근방법은
 		D[i] = D[i-1] + a[i];
 	로 i번째 집까지 구했을 때 최솟값을 가지려면은 D[i-1]의 값에 a[i]의 최솟값을 더하는 방식이다.
 	
 	그런데 여기서 집을 색칠할 수 있는 가짓수가 3개이므로 
 		D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + a[i][0];
 	이런 식을 바꾸어야 한다.
 	
 	위의 식과 다른 점은 위의 식은 색깔을 고려하지 않지만 밑의 식은  색깔을 고려한다는 점이 다르다.
 	아래의 식은 i번째 집까지 색칠했는데 마지막 집을 0으로 칠한것을 의미한다.
 	색이 옆집과 겹치면 안되므로 i-1번재까지 색칠 된것 중 마지막 집이 1, 2인 경우 중 최소값인 것만 고려하는 식으로 문제를 풀었다.
 */
public class BJ_1149_RGB거리 {
	static int[][] prices = new int[1001][3];
	static int[][] memo = new int[1001][3];
	
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N ; i++) {
			StringTokenizer cut = new StringTokenizer(br.readLine());
			prices[i][0] = Integer.parseInt(cut.nextToken());
			prices[i][1] = Integer.parseInt(cut.nextToken());
			prices[i][2] = Integer.parseInt(cut.nextToken());
			
			memo[i][0] = ((memo[i-1][1] < memo[i-1][2]) ? memo[i-1][1] : memo[i-1][2]) + prices[i][0];
			memo[i][1] = ((memo[i-1][0] < memo[i-1][2]) ? memo[i-1][0] : memo[i-1][2]) + prices[i][1];
			memo[i][2] = ((memo[i-1][1] < memo[i-1][0]) ? memo[i-1][1] : memo[i-1][0]) + prices[i][2];
		}
		
		for(int i = 0; i < 3; i++) {
			result = result > memo[N][i] ? memo[N][i] : result;
		}
		
		System.out.println(result);
	}
}
