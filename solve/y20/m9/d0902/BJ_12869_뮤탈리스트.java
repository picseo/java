package d0902;

import java.util.*;

public class BJ_12869_¹ÂÅ»¸®½ºÆ® {
	static int N;
	static int[][][] memo = new int[61][61][61];
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		input = new int[3];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		for(int[][] a : memo) {
			for(int[] b : a) {
				Arrays.fill(b,  -1);
			}
		}
		
		find(input[0], input[1], input[2]);
		
		System.out.println(memo[input[0]][input[1]][input[2]]);
	}

	private static int find(int i, int j, int k) {
		if(i < 0) i = 0;
		if(j < 0) j = 0;
		if(k < 0) k = 0;
		
		if(memo[i][j][k] != -1) {
			return memo[i][j][k];
		}
		
		if(i+j+k == 0) {
			return 0;
		}
		
		memo[i][j][k] = 0;
		//6°¡Áö¸¦ ¼öÇà
		int min = Integer.MAX_VALUE;
		int tmp = find(i-9, j-3, k-1);
		if(min > tmp) min = tmp;
		
		tmp = find(i-3, j-9, k-1);
		if(min > tmp) min = tmp;
		
		tmp = find(i-9, j-1, k-3);
		if(min > tmp) min = tmp;
		
		tmp = find(i-3, j-1, k-9);
		if(min > tmp) min = tmp;
		
		tmp = find(i-1, j-3, k-9);
		if(min > tmp) min = tmp;
		
		tmp = find(i-1, j-9, k-3);
		if(min > tmp) min = tmp;
		
		memo[i][j][k] = min+1;
		return memo[i][j][k];
	}
	
	

}
