package d0903;

import java.util.*;

public class BJ_15486_Επ»η2 {
	static int N;
	static int[][] input;
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		input = new int[N][2];
		for(int i = 0; i < N; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}
		
		memo = new int[N+1];
		memo[0] = 0;
		for(int i =0 ; i < N; i++) {
			if(i + input[i][0] <= N) {
				memo[i+input[i][0]] = Math.max(memo[i+input[i][0]], memo[i]+input[i][1]);
			}
			
			memo[i+1] = Math.max(memo[i+1], memo[i]);
		}
		
		System.out.println(memo[N]);
	}
}
