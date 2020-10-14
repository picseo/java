package d0902;

import java.util.*;

public class BJ_15486_Åð»ç2 {
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
		
		memo = new int[N+2];
		for(int i =0 ; i < N; i++) {
			//Æ÷ÇÔ
			if(i+input[i][0] <= N+1) {
				memo[i+input[i][0]] = Math.max(memo[i+input[i][0]], memo[i]+input[i][1]);
			}
			memo[i+1] = Math.max(memo[i+1],  memo[i]);
		}
		
		System.out.println(memo[N]);
	}

}
