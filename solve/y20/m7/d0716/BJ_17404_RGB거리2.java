package d0716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//RGB거리랑 같은 개념인데 1은 직선거리에 집들이 늘어있다면 2는 원형 거리에 집들이 늘어진거가 다른점이다
//결국 첫번째나 마지막 값중 한개를 고정하고 시작해야 한다.
public class BJ_17404_RGB거리2 {
	static int N;
	static int[][] prices;
	static int[][] memo;
	static int MAX = 2000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		prices = new int[N+2][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				prices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = MAX;
		memo = new int[N+2][3];
		for(int i = 0; i < 3; i++) {
			memo[0][i] = prices[0][i];
			memo[0][(i+1)%3] = MAX;
			memo[0][(i+2)%3] = MAX;
			
			for(int j = 1; j < N; j++) {
				memo[j][0] = Math.min(memo[j-1][1],  memo[j-1][2]) + prices[j][0];
				memo[j][1] = Math.min(memo[j-1][0],  memo[j-1][2]) + prices[j][1];
				memo[j][2] = Math.min(memo[j-1][1],  memo[j-1][0]) + prices[j][2];
			}
			
			result = Math.min(Math.min(result, memo[N-1][(i+1)%3]), memo[N-1][(i+2)%3]);
		}
		
		System.out.println(result);
	}

}
